package ru;

import ru.annotation.AfterSuite;
import ru.annotation.BeforeSuite;
import ru.annotation.Test;
import ru.exception.AnnotationCountException;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by thetekst on 20.06.17.
 */
public class TestInvoker {

    public static void start(Class className) {
        inspector(className);
    }

    public static void start(String className) {
        try {
            Class stringClass = Class.forName(className);
            inspector(stringClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void inspector(Class aClass) {
        Method[] methods = aClass.getDeclaredMethods();
        Map<String, Method> map = new HashMap<>();
        List<Method> tests = new ArrayList<>();

        for (Method method : methods) {
            final Annotation[] annotations = method.getAnnotations();

            if (annotations.length != 1) {
                throw new AnnotationCountException("exeption length != 1");
            }

            Annotation annotation = annotations[0];

            if (annotation instanceof BeforeSuite) {
                if (map.containsKey(annotation)) {
                    throw new AnnotationCountException("exeption BeforeSuite");
                }
                map.put(annotation.toString(), method);
                continue;
            }

            if (annotation instanceof AfterSuite) {
                if (map.containsKey(annotation)) {
                    throw new AnnotationCountException("exeption AfterSuite");
                }
                map.put(annotation.toString(), method);
                continue;
            }

            if (annotation instanceof Test) {
                tests.add(method);
            }
        }
        invokeMethods(map, tests);
    }

    private static void invokeMethods(Map<String, Method> map, List<Method> tests) {
        TestClass testClass = new TestClass();

        if (map.containsKey("@ru.annotation.BeforeSuite()")) {
            try {
                map.get("@ru.annotation.BeforeSuite()").invoke(testClass, null);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        tests.sort((Method m1, Method m2) -> {
            Test t1 = m1.getAnnotation(Test.class);
            Test t2 = m2.getAnnotation(Test.class);
            return (t1.priority() < t2.priority()) ? 1 :
                    (t1.priority() > t2.priority()) ? -1 : 0;
        });

        tests.forEach((k) -> {
            try {
                k.invoke(testClass, null);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });

        if (map.containsKey("@ru.annotation.AfterSuite()")) {
            try {
                map.get("@ru.annotation.AfterSuite()").invoke(testClass, null);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}

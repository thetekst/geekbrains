package ru.test.service;

import ru.TestClass;
import ru.test.annotation.AfterSuite;
import ru.test.annotation.BeforeSuite;
import ru.test.annotation.Test;
import ru.test.exception.AnnotationCountException;
import ru.test.model.impl.TestUnitImpl;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

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
        TestUnitImpl testUnit = new TestUnitImpl();

        for (Method method : methods) {
            final Annotation[] annotations = method.getAnnotations();

            if (annotations.length != 1) {
                throw new AnnotationCountException("exeption length != 1");
            }

            Annotation annotation = annotations[0];

            if (annotation instanceof BeforeSuite) {
                testUnit.setBefore(method);
                continue;
            }

            if (annotation instanceof AfterSuite) {
                testUnit.setAfter(method);
                continue;
            }

            if (annotation instanceof Test) {
                testUnit.addToTestList(method);
            }
        }
        testUnit.sortTests();
        invokeMethods(testUnit);
    }

    private static void invokeMethods(TestUnitImpl testUnit) {
        final TestClass testClass = new TestClass();
        final Method before = testUnit.getBefore();
        final Method after = testUnit.getAfter();
        final List<Method> tests = testUnit.getTestList();

        if (null != before) {
            try {
                before.invoke(testClass, null);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        if (null != tests) {
            tests.forEach((k) -> {
                try {
                    k.invoke(testClass, null);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            });
        }

        if (null != after) {
            try {
                after.invoke(testClass, null);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}

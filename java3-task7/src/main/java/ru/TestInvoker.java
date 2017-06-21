package ru;

import ru.annotation.AfterSuite;
import ru.annotation.BeforeSuite;
import ru.exception.AnnotationCountException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by thetekst on 20.06.17.
 */
public class TestInvoker {

    public static /*<T extends Class>*/ void start(Class className) {
        Class stringClass = className.getClass();
        inspector(stringClass);
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
//        Annotation[] anns = TestClass.class.getDeclaredAnnotations();
//        for (Annotation an : anns) {
//            System.out.println(an);
//        }

        Method[] methods = TestClass.class.getDeclaredMethods();
        Map<Annotation, Method> map = new HashMap<>();

        for (Method method : methods) {
            String methodName = method.getName();
//            System.out.println(methodName);


            final Annotation[] annotations = method.getAnnotations();

            if (annotations.length != 1) throw new AnnotationCountException("exeption length != 1");

            Annotation annotation = annotations[0];

            if (annotation instanceof BeforeSuite) {
                if (map.containsKey(annotation)) {
                    throw new AnnotationCountException("exeption BeforeSuite");
                }
                map.put(annotation, method);
                continue;
            }

            if (annotation instanceof AfterSuite) {
                if (map.containsKey(annotation)) {
                    throw new AnnotationCountException("exeption AfterSuite");
                }
                map.put(annotation, method);
                continue;
            }
//            for(Annotation annotation : annotations) {
//                if (annotation instanceof BeforeSuite) {
//                    System.out.println("BeforeSuite");
//                }
//            }
        }
        map.forEach((k, v) -> System.out.println(k));

//        System.out.println(currentClass.getSimpleName());
//        currentClass = TestClass.class;
//        Annotation[] annotations = currentClass.getDeclaredAnnotations();
//        System.out.println(annotations.length);
//
//        for (Annotation annotation : annotations) {
//            System.out.println(annotation.toString());
//            if (annotation instanceof BeforeSuite) {
//                BeforeSuite beforeSuite = (BeforeSuite) annotation;
//                System.out.println("value: ");
//                System.out.println(beforeSuite);
//            }
////            if (annotation.getAnnotation(BeforeSuite.class) != null) {
////                try {
////                    method.invoke(currentClass);
////                } catch (IllegalAccessException | InvocationTargetException e) {
////                    e.printStackTrace();
////                }
////            }
//        }
    }
}

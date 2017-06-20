package ru;

import ru.annotation.BeforeSuite;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

    private static void inspector(Class currentClass) {
        System.out.println(currentClass.getSimpleName());
        currentClass = TestClass.class;
        Annotation[] annotations = currentClass.getDeclaredAnnotations();
        System.out.println(annotations.length);

        for (Annotation annotation : annotations) {
            System.out.println(annotation.toString());
            if (annotation instanceof BeforeSuite) {
                BeforeSuite beforeSuite = (BeforeSuite) annotation;
                System.out.println("value: ");
                System.out.println(beforeSuite);
            }
//            if (annotation.getAnnotation(BeforeSuite.class) != null) {
//                try {
//                    method.invoke(currentClass);
//                } catch (IllegalAccessException | InvocationTargetException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
}

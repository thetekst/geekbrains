package ru;

import ru.test.service.TestInvoker;

/**
 * Created by thetekst on 19.06.17.
 */
public class Lesson7 {

    public static void main(String[] args) {
        TestInvoker.start(TestClass.class);
//        TestInvoker.start("ru.TestClass");
    }
}

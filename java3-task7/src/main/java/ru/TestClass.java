package ru;

import ru.annotation.AfterSuite;
import ru.annotation.BeforeSuite;
import ru.annotation.Test;

/**
 * Created by thetekst on 21.06.17.
 */
public class TestClass {

    @BeforeSuite
    public void init() {
        System.out.println("before");
    }

    @Test
    public void test1() {
        System.out.println("test 1");
    }

    @Test
    public void test2() {
        System.out.println("test 2");
    }

    @AfterSuite
    public void end() {
        System.out.println("end");
    }
}

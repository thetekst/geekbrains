package ru;

import ru.test.annotation.AfterSuite;
import ru.test.annotation.BeforeSuite;
import ru.test.annotation.Test;

/**
 * Created by thetekst on 21.06.17.
 */
public class TestClass {

    @AfterSuite
    public void end() {
        System.out.println("end");
    }

    @BeforeSuite
    public void init() {
        System.out.println("before");
    }

    @Test
    public void test1() {
        System.out.println("p5");
    }

    @Test(priority = 10)
    public void test6() {
        System.out.println("p10");
    }

    @Test(priority = 1)
    public void test4() {
        System.out.println("p1");
    }

    @Test(priority = 8)
    public void test2() {
        System.out.println("p8");
    }

    @Test(priority = 1)
    public void test3() {
        System.out.println("p1");
    }

    @Test(priority = 10)
    public void test5() {
        System.out.println("p10");
    }
}

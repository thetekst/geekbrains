package ru.test.model;

import java.lang.reflect.Method;

/**
 * @author thetekst
 *         created on 24.06.17.
 */
public interface TestUnit {

    void addToTestList(Method test);

    void sortTests();
}

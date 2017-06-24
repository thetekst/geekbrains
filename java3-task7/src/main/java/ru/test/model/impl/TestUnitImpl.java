package ru.test.model.impl;

import ru.test.annotation.Test;
import ru.test.model.TestUnit;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author thetekst
 *         created on 24.06.17.
 */
public class TestUnitImpl implements TestUnit {

    private Method before;

    private Method after;

    private List<Method> testList;

    public TestUnitImpl() {
    }

    public Method getBefore() {
        return before;
    }

    public void setBefore(Method before) {
        this.before = before;
    }

    public Method getAfter() {
        return after;
    }

    public void setAfter(Method after) {
        this.after = after;
    }

    public List<Method> getTestList() {
        return testList;
    }

    @Override
    public void addToTestList(Method test) {
        if (null == this.testList) {
            this.testList = new ArrayList<>();
        }
        this.testList.add(test);
    }

    @Override
    public void sortTests() {
        if (null != this.testList) {
            this.testList.sort((Method m1, Method m2) -> {
                Test t1 = m1.getAnnotation(Test.class);
                Test t2 = m2.getAnnotation(Test.class);
                return (t1.priority() < t2.priority()) ? 1 :
                        (t1.priority() > t2.priority()) ? -1 : 0;
            });
        }
    }
}

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * Created by dtkachenko on 14.06.2017.
 */
@RunWith(Parameterized.class)
public class Task6TestParameterized {

    public static Task6 task6;

    @Parameterized.Parameter()
    public Integer[] actual;

    @Parameterized.Parameter(1)
    public Integer[] expected;

    @Parameterized.Parameters
    public static Iterable data() {
        return Arrays.asList(
                new Object[][]{
                        {new Integer[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new Integer[]{1, 7}},
                        {new Integer[]{10, 2, 4, 55, 2, 3, 1, 1, 7}, new Integer[]{55, 2, 3, 1, 1, 7}},
                        {new Integer[]{4}, new Integer[]{}},
                });

    }

    @BeforeClass
    public static void init() {
        task6 = new Task6();
    }

    @Test
    public void getArrayByCriteria1() {
        Assert.assertArrayEquals(expected, task6.getArrayByCriteria(actual));
    }
}
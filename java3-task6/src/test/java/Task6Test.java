import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by dtkachenko on 14.06.2017.
 */
@RunWith(Parameterized.class)
public class Task6Test {

    public Task6 task6;

    @Parameterized.Parameter()
    public Integer[] actual;

    @Parameterized.Parameter(1)
    public Integer[] expected;


    @Parameterized.Parameters
    public static Iterable data() {
        return Arrays.asList(
                new Object[][]{
                        {new Integer[] {1, 2, 4, 4, 2, 3, 4, 1, 7}, new Integer[] {1, 7}},
                        {new Integer[] {10, 2, 4, 55, 2, 3, 1, 1, 7}, new Integer[] {55, 2, 3, 1, 1, 7}},
//                        {new Integer[] {1, 2, 5}, null}
                });

    }

    @Before
    public void init() {
        this.task6 = new Task6();
    }

    @Test
    public void getArrayByCriteria1() throws Exception {
        Assert.assertArrayEquals(expected, task6.getArrayByCriteria(actual));
    }

    @Test(expected = RuntimeException.class)
    public void getArrayByCriteria2() throws Exception {
        Assert.assertArrayEquals(null, task6.getArrayByCriteria(new Integer[] {1, 2, 5}));
    }

//    @Test
//    public void getArrayByCriteria3() throws Exception {
//
//    }

}
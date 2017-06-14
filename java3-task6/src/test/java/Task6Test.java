import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Created by dtkachenko on 14.06.2017.
 */
@RunWith(Parameterized.class)
public class Task6Test {

    private Task6 task6;
    private Integer[] actual;
    private Integer[] expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Integer[][] {{1,3},{1,3}},
                new Integer[][] {{1,3},{1,3}});
    }

    @Before
    public void init() {
        this.task6 = new Task6();
    }

    @Test
    public void getArrayByCriteria1() throws Exception {
        int[] array = {1,2,4,4,2,3,4,1,7};
        Integer[] newArray = task6.getArrayByCriteria(array);
        Integer[] expected = {1,7};
        Integer integer = new Integer(new int[]{1, 3});
        Assert.assertArrayEquals(expected, newArray);
    }

    @Test
    public void getArrayByCriteria2() throws Exception {

    }

    @Test
    public void getArrayByCriteria3() throws Exception {

    }

}
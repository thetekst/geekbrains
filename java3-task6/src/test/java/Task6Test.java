import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

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

    // Александр, есть ли способ сделать так, чтобы в тестовом методе getArrayByCriteria2() не выполнялся метод с параметризацией?
    // Чтобы параметризация выполнялась только в методе getArrayByCriteria1()
    // Сейчас эти праметры во все тестовые методы передаются
    @Parameterized.Parameters
    public static Iterable data() {
        return Arrays.asList(
                new Object[][]{
                        {new Integer[] {1, 2, 4, 4, 2, 3, 4, 1, 7}, new Integer[] {1, 7}},
                        {new Integer[] {10, 2, 4, 55, 2, 3, 1, 1, 7}, new Integer[] {55, 2, 3, 1, 1, 7}},
                        {new Integer[] {4}, new Integer[] {}},
                });

    }

    @Before
    public void init() {
        this.task6 = new Task6();
    }

    @Test
    public void getArrayByCriteria1() {
        Assert.assertArrayEquals(expected, task6.getArrayByCriteria(actual));
    }

    @Test(expected = RuntimeException.class)
    public void getArrayByCriteria2() {
        Assert.assertArrayEquals(null, task6.getArrayByCriteria(new Integer[] {1, 2, 5}));
    }

    @Test
    public void isArrayCorrect1() {
        Assert.assertFalse(task6.isArrayCorrect(new int[] {1,3,5}));
    }

    @Test
    public void isArrayCorrect2() {
        Assert.assertTrue(task6.isArrayCorrect(new int[] {1,4,1,1,1,4}));
    }

    @Test
    public void isArrayCorrect3() {
        Assert.assertFalse(task6.isArrayCorrect(new int[] {1,1,1,1}));
    }
}
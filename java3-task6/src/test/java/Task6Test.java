import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by usr on 16.06.2017.
 */
public class Task6Test {

    public static Task6 task6;

    @BeforeClass
    public static void runTest() {
        task6 = new Task6();
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

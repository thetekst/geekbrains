import java.util.ArrayList;
import java.util.List;

/**
 * Created by dtkachenko on 14.06.2017.
 */
public class Task6 {

    public Integer[] getArrayByCriteria(Integer[] array) {
        final int len = array.length;
        boolean found = false;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            final int item = array[i];
            if (4 == item) {
                found = true;
                list.clear();
                continue;
            }
            if (found) list.add(item);
        }

        if (!found) throw new RuntimeException();
        return list.toArray(new Integer[list.size()]);

    }

    public boolean isArrayCorrect(int[] array) {
        int one = 0;
        int four = 0;
        final int len = array.length;

        for (int i = 0; i < len; i++) {
            final int item = array[i];
            if (item != 1 && item != 4)  {
                return false;
            }
            if (1 == item) {
                one++;
            }
            if (4 == item) {
                four++;
            }
        }
        return one > 0 && four > 0;
    }
}

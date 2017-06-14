import java.util.ArrayList;
import java.util.List;

/**
 * Created by dtkachenko on 14.06.2017.
 */
public class Task6 {

    public Integer[] getArrayByCriteria(Integer[] array) {
        int len = array.length;
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
}

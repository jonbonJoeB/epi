import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FindKthLargest {

    /*
    11.8
    */

    private static final Random rnd = new Random();

    public static int findKth(List<Integer> list, int k) {
        int lo = 0, hi = list.size() - 1, n = list.size();

        int target = n - k + 1;
        while (lo <= hi) {
            int p = partition(list, lo, hi);
            if (p == target - 1) {
                return list.get(p);
            } else if (p < target) {
                lo = p + 1;
            } else {
                hi = p - 1;
            }
        }

        return -1;
    }

    private static int partition(List<Integer> list, int lo, int hi) {
        int pIndex = rnd.nextInt(hi - lo) + lo;
        int pivot = list.get(pIndex);

        Collections.swap(list, pIndex, hi);

        int left = lo;
        for (int i = lo; i < hi; i++) {
            if (list.get(i) < pivot) {
                Collections.swap(list, i, left);
                left++;
            }
        }

        Collections.swap(list, left, hi);

        return left;
    }
}

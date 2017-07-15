import java.util.List;

public class SearchSorted {

    /*
    11.1
    */

    /**
     * Returns the index of the first occurrence of k
     * in the given list
     *
     * @param list
     * @param k
     * @return
     */
    public static int search(List<Integer> list, int k) {
        int lo = 0, hi = list.size() - 1;

        int res = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) == k) {
                res = mid;

                // Continue to move left
                hi = mid - 1;
            } else if (list.get(mid) < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return res;
    }
}

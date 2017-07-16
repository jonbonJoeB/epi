import java.util.List;

public class SearchSortedCyclic {

    /*
    11.3
    */

    public static int search(List<Integer> list) {
        int lo = 0, hi = list.size() - 1;

        // If the entire input is already sorted, i.e. no rotations
        if (list.get(lo) <= list.get(hi)) {
            return list.get(lo);
        }

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (mid > 0 && list.get(mid - 1) > list.get(mid) && mid < list.size() && list.get(mid) < list.get(mid + 1)) {
                return list.get(mid);
            }

            // If left side is sorted
            else if (list.get(lo) < list.get(mid)) {
                lo = mid + 1;
            }
            // If right side is sorted
            else if (list.get(mid) < list.get(hi)) {
                hi = mid - 1;
            }

        }

        return 0;
    }
}

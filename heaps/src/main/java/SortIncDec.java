import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortIncDec {

    /*
    10.2
    */

    private enum CurrentOrder {
        INCREASING,
        DECREASING
    }

    public static List<Integer> sort(List<Integer> list) {
        CurrentOrder currentOrder = CurrentOrder.INCREASING;

        List<List<Integer>> sublists = new ArrayList<>();

        int startOfSublist = 0;
        for (int i = 1; i < list.size(); i++) {
            if (CurrentOrder.INCREASING.equals(currentOrder)) {
                if (list.get(i) < list.get(i - 1)) {
                    currentOrder = CurrentOrder.DECREASING;
                    sublists.add(list.subList(startOfSublist, i));
                    startOfSublist = i;
                }
            } else {
                if (list.get(i) > list.get(i - 1)) {
                    currentOrder = CurrentOrder.INCREASING;
                    sublists.add(list.subList(startOfSublist, i));
                    startOfSublist = i;
                }
            }
        }

        // Capture the last sublist
        sublists.add(list.subList(startOfSublist, list.size()));

        for (int i = 1; i < sublists.size(); i += 2) {
            Collections.reverse(sublists.get(i));
        }

        return MergeSortedFiles.mergeSorted(sublists);
    }
}

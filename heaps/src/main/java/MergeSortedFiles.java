import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class MergeSortedFiles {

    /*
    10.1
    */

    private static class IndexValuePair {
        final int index;
        final int value;

        IndexValuePair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static List<Integer> mergeSorted(List<List<Integer>> sortedArrays) {
        if (sortedArrays == null || sortedArrays.size() == 0 || sortedArrays.get(0).size() == 0) {
            return Collections.emptyList();
        }

        final List<Integer> sortedResult = new ArrayList<>();

        final List<Iterator<Integer>> iters = sortedArrays.stream().map(a -> a.iterator()).collect(Collectors.toList());

        final Queue<IndexValuePair> minHeap = new PriorityQueue<>(sortedArrays.size(),
                Comparator.comparingInt(o -> o.value));

        // Add the first 'k' elements
        for (int i = 0; i < iters.size(); i++) {
            if (iters.get(i).hasNext()) {
                minHeap.add(new IndexValuePair(i, iters.get(i).next()));
            }
        }

        while (!minHeap.isEmpty()) {
            final IndexValuePair cur = minHeap.poll();

            sortedResult.add(cur.value);

            if (iters.get(cur.index).hasNext()) {
                minHeap.add(new IndexValuePair(cur.index, iters.get(cur.index).next()));
            }
        }

        return sortedResult;
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortAlmostSorted {

    /*
    10.3
    */

    /**
     * Sorts a nearly sorted array. Each element is at most k positions
     * away from its sorted position. This solution leverages a min heap
     * of size k + 1 elements.
     *
     * @param sequence
     * @param k
     * @return
     */
    public static List<Integer> sort(Iterator<Integer> sequence, int k) {
        final List<Integer> sorted = new ArrayList<>();

        final Queue<Integer> minHeap = new PriorityQueue<>();

        // Add the first k elements to the heap
        while (minHeap.size() < k + 1) {
            if (sequence.hasNext()) {
                minHeap.add(sequence.next());
            }
        }

        // Core logic of the algorithm
        while (sequence.hasNext()) {
            sorted.add(minHeap.poll());
            minHeap.add(sequence.next());
        }

        // Include the remaining elements
        while (!minHeap.isEmpty()) {
            sorted.add(minHeap.poll());
        }

        return sorted;
    }

}

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ComputeMedianOnline {

    /*
    10.5
    */

    private static final Queue<Integer> minHeap = new PriorityQueue<>();
    private static final Queue<Integer> maxHeap = new PriorityQueue<>(5, Collections.reverseOrder());

    public static List<Double> onlineMedian(Iterator<Integer> sequence) {
        final List<Double> medians = new ArrayList<>();

        while (sequence.hasNext()) {
            minHeap.add(sequence.next());
            maxHeap.add(minHeap.poll());

            if (maxHeap.size() > minHeap.size()) {
                minHeap.add(maxHeap.poll());
            }

            medians.add(getCurrentMedian());
        }

        return medians;
    }

    private static Double getCurrentMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek().doubleValue();
        }

        return 0.5 * (minHeap.peek() + maxHeap.peek());
    }
}

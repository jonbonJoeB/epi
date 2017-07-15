import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ComputeKClosest {

    /*
    10.4
    */

    private static final Star EARTH_COORDINATES = new Star(0,0,0);

    public static List<Star> getKClosest(int k, Iterator<Star> stars) {
        final Queue<Star> maxHeap =
                new PriorityQueue<>(k + 1,
                        Collections.reverseOrder(
                                Comparator.comparingDouble(o -> o.distance())));

        while (stars.hasNext()) {
            final Star star = stars.next();

            if (maxHeap.size() < k) {
                maxHeap.add(star);
            } else {
                if (star.distance() < maxHeap.peek().distance()) {
                    maxHeap.add(star);
                    maxHeap.poll();
                }
            }
        }

        final List<Star> kClosest = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            kClosest.add(maxHeap.poll());
        }

        Collections.sort(kClosest);

        return kClosest;
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputeIntersection {

    /*
    13.1
    */

    public static List<Integer> intersection(List<Integer> A, List<Integer> B) {
        final List<Integer> intersection = new ArrayList<>();

        int prev = -1;
        int i = 0, j = 0;
        while (i < A.size() && j < B.size()) {

            while (i < A.size() && A.get(i) < B.get(j)) i++;
            if (i == A.size()) break;

            while (j < B.size() && B.get(j) < A.get(i)) j++;
            if (j == B.size()) break;

            if (i < A.size() && j < B.size() && A.get(i) == B.get(j)) {
                intersection.add(A.get(i));
                prev = A.get(i);
                i++;
                j++;
            }

            // Ignore duplicates
            while (i < A.size() && A.get(i) == prev) i++;
            while (j < B.size() && B.get(j) == prev) j++;
        }

        return intersection;
    }
}

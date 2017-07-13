import java.util.List;

public class DutchNationalFlag {

    /*
    5.1
    */

    /**
     * This algorithm solves the dutch national flag partition problem
     * by keeping track of the current end idx of contiguous subarray of elements
     * less than the pivot, the end idx of the contiguous subarray of elements
     * equal to the pivot, and the start idx of the contiguous subarray of elements
     * larger than the pivot. This allows us to swap elements into their proper
     * location as we come across them in a single iteration.
     *
     * @param p
     * @param A
     */
    public static void dutchNationalFlag(int p, List<Integer> A) {
        int left = 0;
        int middle = 0;
        int right = A.size() - 1;

        while (middle < right) {
            int cur = A.get(middle);
            if (cur == p) {
                middle++;
            } else if (cur < p) {
                swap(A, middle, left);
                left++;
                middle++;
            } else {
                swap(A, middle, right);
                right--;
            }
        }
    }

    private static void swap(List<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }
}

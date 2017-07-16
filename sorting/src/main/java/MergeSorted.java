import java.util.List;

public class MergeSorted {

    /*
    13.2
    */

    public static void merge(List<Integer> A, int m, List<Integer> B, int n) {
        int writeIdx = A.size() - 1;

        int i = m - 1, j = n - 1;
        while (writeIdx >= 0 && i >= 0 && j >= 0) {
            A.set(writeIdx--, A.get(i) > B.get(j) ? A.get(i--) : B.get(j--));
        }

        while (writeIdx >= 0 && j >= 0) {
            A.set(writeIdx--, B.get(j--));
        }
    }
}

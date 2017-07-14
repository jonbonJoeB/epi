import java.util.Collections;
import java.util.List;

public class IncrementArbitraryPrecisionInteger {

    /*
    5.2
    */

    public static List<Integer> incrementInteger(List<Integer> A) {
        if (A == null) {
            return A;
        }

        // First reverse the given list
        Collections.reverse(A);

        // Keep track of the carry
        int carry = 1;
        for (int i = 0; i < A.size(); i++) {
            int num = A.get(i) + carry;
            A.set(i, num % 10);
            carry = num / 10;
        }

        if (carry > 0) {
            A.add(carry);
        }

        // Reverse the list back to normal
        Collections.reverse(A);
        return A;
    }
}

public class IntegerSquareRoot {

    /*
    11.4
    */

    public static int squareRoot(int n) {
        // Binary search for the correct answer
        if (n <= 1) {
            return n; // Handles 0 and 1
        }

        int res = -1;
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid * mid == n) {
                // Nothing can be better
                return mid;
            } else if (mid * mid < n) {
                // Update candidate
                res = mid;

                // Continue right
                lo = mid + 1;
            } else {
                // Need to check lesser values
                hi = mid - 1;
            }
        }

        return res;
    }
}

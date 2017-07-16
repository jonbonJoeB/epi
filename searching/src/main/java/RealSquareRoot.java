public class RealSquareRoot {

    /*
    11.5
    */

    private enum Ordering { EQUAL, SMALLER, LARGER };

    private static final double EPSILON = 0.00001;

    private static Ordering compare(double x, double y) {
        double diff = (x - y) / y;
        return diff < -EPSILON
                ? Ordering.SMALLER
                :  (diff > EPSILON ? Ordering.LARGER : Ordering.EQUAL);
    }

    public static double squareRoot(double x) {
        double left, right;
        if (x < 1.0) {
            left = x;
            right = 1.0;
        } else {
            left = 1.0;
            right = x;
        }

        while (compare(left, right) != Ordering.EQUAL) {
            double mid = left + (right - left) / 2;

            if (compare(mid * mid, x) == Ordering.SMALLER) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }
}

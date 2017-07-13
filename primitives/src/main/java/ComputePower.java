public class ComputePower {

    /*
    4.7
    */

    /**
     * This algorithms work through exponentiation by squaring.
     *
     * This is from the observation that for x^n can be broken down
     * into two scenarios
     *
     * x^n = (x^2)^n/2          if n is even
     *  - Read: x quantity squared to the power of n/2
     *
     * x^n = x(x^2)^(n-1)/2     if n is odd
     *  - Read: x times x quantity squared to the power of (n-1)/2
     *
     * @param x
     * @param y
     * @return
     */
    public static double power(double x, int y) {
        if (x == 0) return 0;
        if (x == 1 || y == 0) return 1;
        if (y < 0) {
            y = -y;
            x = 1 / x;
        }

        double z = 1;
        while (y > 1) {
            if (y % 2 == 0) { // even case
                x = x * x;
                y = y / 2;
            } else { // odd case
                z = x * z;
                x = x * x;
                y = (y - 1) / 2;
            }
        }

        return x * z;
    }
}

public class ComputeParity {

    /*
    4.1
    */

    /**
     * Returns the parity of the given variable. This is 1 for
     * values that have an odd number of bits set to 1, and 0
     * for values that have an even numbers of bits set to 1.
     *
     * @param n
     * @return
     */
    public static short parity(long n) {
        short parity = 0;
        while (n != 0) {
            n = n & (n - 1);
            parity ^= 1;
        }
        return parity;
    }
}

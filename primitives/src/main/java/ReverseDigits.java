public class ReverseDigits {

    /*
    4.8
    */

    /**
     * Reversed the input by first calculating the log base 10 of the input
     * to figure out how many digit places we need to account for, then iteratively
     * adds 10^place * current digit
     *
     * It can also be solved by just multiplying the current result by 10 each time
     * then adding the current digit:
     *      reversed = reversed * 10 + digit;
     *
     * @param x
     * @return
     */
    public static long reverse(int x) {
        if (x == 0) {
            return 0;
        }

        boolean negative = x < 0;
        x = Math.abs(x);

        long reversed = 0;
        int place = logBase10(x); // Tells us the furthest digit place to start from

        while (x > 0) {
            int digit = x % 10;
            x /= 10;

            reversed += Math.pow(10, place) * digit;
            place--;

            //reversed = reversed * 10 + digit;
        }

        return negative ? -reversed : reversed;
    }

    /**
     * This returns the log base 10 of the given x
     *
     * @param x
     * @return
     */
    private static int logBase10(int x) {
        return (int)(Math.log(x) / Math.log(10));
    }
}

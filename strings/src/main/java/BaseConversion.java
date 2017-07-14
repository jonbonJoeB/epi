public class BaseConversion {

    /*
    6.2
    */

    private static final char[] KEYS = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };

    /**
     * Converts the given String s (of a number) given in base b1 to
     * a String representing the same number in base b2
     *
     * This solution works by first converting from b1 to an integer (base 10)
     * then converting base 10 to base b2
     *
     * @param s
     * @param b1
     * @param b2
     * @return
     */
    public static String baseConversion(String s, int b1, int b2) {
        if (s == null || s.length() == 0) {
            return "";
        }

        return convertToString(convertToInt(s, b1), b2);
    }

    private static String convertToString(int n, int base) {
        boolean negative = n < 0;
        n = Math.abs(n);

        final StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int mod = n % base;
            sb.append(KEYS[mod]);
            n /= base;
        }
        if (negative) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }

    private static int convertToInt(String s, int base) {
        boolean isNegative = s.startsWith("-");

        int res = 0;
        for (int i = (isNegative ? 1 : 0); i < s.length(); i++) {
            res *= base;
            res += Character.isDigit(s.charAt(i))
                    ? Character.getNumericValue(s.charAt(i))
                    : s.charAt(i) - 'A' + 10;
        }

        return isNegative ? -res : res;
    }

    private static int logBaseB(int value, int b) {
        return (int)(Math.log(value) / Math.log(b));
    }
}

public class ReplaceAndRemove {

    /*
    6.4
    */

    /**
     * Removes all 'b's and replaces all 'a's with 'dd'
     *
     * Example:
     *
     *   "abfcdeba" -> "ddfcdedd"
     * @param s
     * @param k
     * @return
     */
    public static String replaceAndRemove(char[] s, int k) {
        return replaceAndRemove(new String(s), 0);
    }

    private static String replaceAndRemove(String s, int idx) {
        if (idx + 1 > s.length()) {
            return s;
        }

        if (s.charAt(idx) == 'b') {
            return replaceAndRemove(s.substring(0, idx) + s.substring(idx + 1), idx); // leave idx the same
        } else if (s.charAt(idx) == 'a') {
            return replaceAndRemove(s.substring(0, idx) + "dd" + s.substring(idx + 1), idx + 2);
        } else {
            return replaceAndRemove(s, idx + 1);
        }
    }

}

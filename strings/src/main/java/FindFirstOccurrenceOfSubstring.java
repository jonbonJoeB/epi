public class FindFirstOccurrenceOfSubstring {

    /*
    6.13
    */

    /**
     * Searches for the given substring within string using Rabin-Karp
     * string matching algorithm with a rolling hash function
     *
     * @param string
     * @param substring
     * @return
     */
    public static int findFirst(String string, String substring) {
        if (string.length() == 0 || substring.length() == 0 || string.length() < substring.length()) {
            return -1;
        }
        final int BASE = 26;

        int stringHash = string.charAt(0);
        int substringHash = substring.charAt(0);

        int powerS = 1;

        for (int i = 1; i < substring.length(); i++) {
            powerS *= BASE;
            stringHash = stringHash * BASE + string.charAt(i);
            substringHash = substringHash * BASE + substring.charAt(i);
        }

        for (int i = substring.length(); i < string.length(); i++) {
            if (stringHash == substringHash && string.substring(i - substring.length(), i).equals(substring)) {
                return i - substring.length();
            }

            // Roll back the last character
            stringHash -= string.charAt(i - substring.length()) * powerS;

            // Add the next character
            stringHash = stringHash * BASE + string.charAt(i);
        }

        if (stringHash == substringHash && string.substring(string.length() - substring.length()).equals(substring)) {
            return string.length() - substring.length();
        }

        return -1;
    }

}

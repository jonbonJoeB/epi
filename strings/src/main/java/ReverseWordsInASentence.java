public class ReverseWordsInASentence {

    /*
    6.6
    */

    public static String reverseWordsInASentence(String input) {
        // The trick is to first reverse the entire string, then
        // reverse each word

        // Reverse the entire input
        input = reverse(input);

        final StringBuilder sb = new StringBuilder();
        for (final String s : input.split("\\s+")) {
            sb.append(reverse(s) + " ");
        }

        return sb.toString().trim();
    }

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}

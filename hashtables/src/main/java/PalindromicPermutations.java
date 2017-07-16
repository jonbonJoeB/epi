import java.util.HashSet;
import java.util.Set;

public class PalindromicPermutations {

    /*
    12.1
    */

    public static boolean canFormPalindrome(String s) {
        final Set<Character> oddLengthCharSet = new HashSet<>();

        for (final Character c : s.toCharArray()) {
            if (oddLengthCharSet.contains(c)) {
                oddLengthCharSet.remove(c);
            } else {
                oddLengthCharSet.add(c);
            }
        }

        return oddLengthCharSet.size() <= 1;
    }
}

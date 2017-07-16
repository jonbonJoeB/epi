import java.util.HashMap;
import java.util.Map;

public class IsLetterConstructable {

    /*
    12.2
    */

    public static boolean isConstructable(String letterText, String magazineText) {
        final Map<Character, Integer> charCounts = new HashMap<>();

        for (Character c : letterText.toCharArray()) {
            c = Character.toLowerCase(c);
            if (!charCounts.containsKey(c)) {
                charCounts.put(c, 0);
            }

            charCounts.put(c, charCounts.get(c) + 1);
        }

        for (Character c : magazineText.toCharArray()) {
            c = Character.toLowerCase(c);

            if (charCounts.isEmpty()) {
                return true;
            }
            if (charCounts.containsKey(c)) {
                int count = charCounts.get(c);
                count--;

                if (count == 0) {
                    charCounts.remove(c);
                } else {
                    charCounts.put(c, count);
                }
            }
        }

        return charCounts.isEmpty();
    }
}

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NearestRepeated {

    /*
    12.6
    */

    public static int findNearest(List<String> paragraph) {
        final Map<String, Integer> wordsToIndex = new HashMap<>();

        int minDistance = Integer.MAX_VALUE;
        boolean duplicateFound = false;
        for (int i = 0; i < paragraph.size(); i++) {
            if (wordsToIndex.containsKey(paragraph.get(i))) {
                minDistance =
                        Math.min(minDistance,
                                 i - wordsToIndex.get(paragraph.get(i)));
                duplicateFound = true;
            }

            wordsToIndex.put(paragraph.get(i), i);
        }

        if (!duplicateFound) {
            return -1;
        }

        return minDistance;
    }
}

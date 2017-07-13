import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class SampleOfflineData {

    /*
    5.12
    */

    public static void randomSampling(int k, List<Integer> list) {
        final Random rnd = new Random();
        final Set<Integer> set = new HashSet<>();
        int n = list.size();

        for (int i = n - k; i < k; i++) {
            int r = list.get(rnd.nextInt(i));
            if (!set.contains(r)) {
                set.add(r);
            } else {
                set.add(list.get(i));
            }
        }
    }
}

import java.util.Arrays;
import java.util.Collections;

public class ReverseBits {

    /*
    4.3
    */

    public static int reverse(int x) {
        if (x == 0) return 0;

        final int[] lookup = new int[32];
        for (int i = 0; i < lookup.length; i++) {
            lookup[i] = 1 & (x >> i);
        }

        reverse(lookup);

        int result = 0;
        for (int i = 0; i < lookup.length; i++) {
            result |= lookup[i] << i;
        }

        return result;
    }

    private static void reverse(final int[] a) {
        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            a[i] ^= a[j];
            a[j] ^= a[i];
            a[i] ^= a[j];
        }
    }
}

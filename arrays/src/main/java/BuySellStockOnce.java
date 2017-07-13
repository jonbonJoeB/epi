import java.util.List;

public class BuySellStockOnce {

    /*
       5.6
    */

    /**
     * Given stock prices of the day, return the largest profit for
     * buying a single stock and selling a single stock for the day.
     *
     * This solution works in linear time with constant space by keeping
     * track of the minimum element seen so far and the max profit calculated
     * so far. The max profit is found by taking the difference between the current
     * element being iterated on and the minimum element seen so far.
     *
     * @param A
     * @return
     */
    public static int buySellStockOnce(List<Integer> A) {
        if (A == null || A.size() <= 1) {
            return 0; // No profit to be made here
        }

        int maxProfit = 0;
        int minPriceSeen = A.get(0);

        for (int i = 1; i < A.size(); i++) {
            maxProfit = Math.max(maxProfit, A.get(i) - minPriceSeen);
            minPriceSeen = Math.min(minPriceSeen, A.get(i));
        }

        return maxProfit;
    }
}

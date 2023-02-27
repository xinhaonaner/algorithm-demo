package kim.fzp.array;

/**
 * @author fzp
 * @date 2023/2/27 23:37
 */
public class Solution122 {


    /**
     * 贪心算法只能用于计算最大利润，计算的过程并不是实际的交易过程
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

}

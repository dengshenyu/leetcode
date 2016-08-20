import java.util.Arrays;
import java.util.Collections;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] ans = new int[amount + 1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (ans[j-coins[i]] != Integer.MAX_VALUE)
                    ans[j] = Math.min(ans[j], ans[j-coins[i]] + 1);
            }
        }
        return ans[amount] != Integer.MAX_VALUE ? ans[amount] : -1;
    }
}
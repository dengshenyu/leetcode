import java.util.*;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {

    public int integerBreak(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            int p = n / i;
            int y = n % i;
            int t = 1;
            int j = i;
            while (j-- > 0) {
                if (y > 0) {
                    t *= (p + 1);
                    y--;
                } else {
                    t *= p;
                }
            }
            if (t > res)
                res = t;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().integerBreak(2));
    }
}
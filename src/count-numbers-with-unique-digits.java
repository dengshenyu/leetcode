import java.util.*;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 1)
            return 10;
        if (n == 0)
            return 1;
        int result = 10;
        for (int i = 2; i <= n && i <= 10; i++) {
            int t = 1;
            int c = 9;
            for (int j = 1; j <= i; j++) {
                if (j == 1)
                    t *= 9;
                else
                    t *= (c--);
            }
            result += t;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countNumbersWithUniqueDigits(2));
    }


}
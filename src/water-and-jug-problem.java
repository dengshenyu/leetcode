import java.util.*;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {

    public boolean canMeasureWater(int x, int y, int z) {
        return (z == 0) || (z <= x + y && z % gcd(x, y) == 0);
    }

    public int gcd(int a, int b) {
        if (a == 0)
            return b;
        else if (b == 0)
            return a;
        return gcd(b, a % b);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().canMeasureWater(104597, 104623, 123));
    }


}
import java.util.*;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {
    public boolean isPowerOfThree(int n) {
        int max = (int)Math.pow(3, (int)(Math.log(0x7fffffff) / Math.log(3)));
        return n > 0 && max % n == 0;
    }

    public static void main(String[] args) {
    }
}
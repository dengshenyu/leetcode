import java.util.*;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {
    public int minPatches(int[] nums, int n) {
        int res = 0, i = 0;
        long miss = 1;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                res++;
                miss += miss;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minPatches(new int[]{1,2,31,33},
        2147483647));
    }
}
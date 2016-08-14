import java.util.*;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {
    private int mergeCount(long[] sum, int left, int right, int lower, int upper) {
        if (right - left <= 1)
            return 0;

        int count = 0, middle = (left + right) / 2;
        count += mergeCount(sum, left, middle, lower, upper);
        count += mergeCount(sum, middle, right, lower, upper);
        int j = middle, k = middle, t = middle;
        long[] cache = new long[right - left];
        for (int i = left, r = 0; i < middle; i++, r++) {
            while (j < right && sum[j] - sum[i] < lower)
                j++;
            while (k < right && sum[k] - sum[i] <= upper)
                k++;
            while (t < right && sum[t] < sum[i])
                cache[r++] = sum[t++];
            cache[r] = sum[i];
            count += k - j;
        }
        System.arraycopy(cache, 0, sum, left, t - left);
        return count;
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums.length == 0)
            return 0;
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++)
            sum[i+1] = sum[i] + nums[i];
        return mergeCount(sum, 0, sum.length, lower, upper );
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countRangeSum(new int[]{-2, 5, -1}, -2, 2));
    }
}
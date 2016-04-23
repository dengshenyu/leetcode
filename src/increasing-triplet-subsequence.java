import java.util.*;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3)
            return false;

        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > b)
                return true;
            if (nums[i] > a && nums[i] < b)
                b = nums[i];
            if (isMinimum(nums, i)) {
                if (nums[i+1] > b)
                    return true;
                else if (nums[i+1] <= b) {
                    a = nums[i];
                    b = nums[i+1];
                    i += 2;
                    continue;
                }
            }
            i += 1;
        }
        return false;
    }

    private boolean isMinimum(int[] nums, int i) {
        if ((i == 0 || nums[i] <= nums[i-1] ) && ( i < nums.length - 1 &&  nums[i] < nums[i+1]))
            return true;
        return false;
    }
}
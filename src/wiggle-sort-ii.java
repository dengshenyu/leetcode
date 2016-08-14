import java.util.Arrays;
import java.util.Collections;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums.length == 0)
            return;
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int middle = (nums.length & 0x1) == 1 ? nums.length / 2 : nums.length / 2 - 1;
        int bigger = sorted.length - 1;
        int smaller = middle;

        for (int i = 0; i < nums.length; i++) {
            if ((i & 0x1) == 0)
                nums[i] = sorted[smaller--];
            else
                nums[i] = sorted[bigger--];
        }
    }
}
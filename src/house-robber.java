import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by shenyuan on 17/2/22.
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int len = nums.length;
        int[] f = new int[nums.length + 1];
        f[len] = 0;
        f[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            int a1 = nums[i] + f[i + 2];
            int a2 = f[i + 1];
            f[i] = (a1 > a2) ? a1 : a2;
        }

        return f[0];
    }
}
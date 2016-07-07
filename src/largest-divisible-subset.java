import java.util.*;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {
    private void sort(int[] nums, int left, int right) {
        if (right <= left)
            return;
        int i = left, j = right - 1;
        while (i <= j) {
            while (nums[i] < nums[right])
                i++;
            while (i <= j && nums[j] > nums[right])
                j--;
            if (i <= j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
        int tmp = nums[right];
        nums[right] = nums[i];
        nums[i] = tmp;
        sort(nums, left, i - 1);
        sort(nums, i + 1, right);
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<Integer>();
        sort(nums, 0, nums.length - 1);
        int[] pre = new int[nums.length];
        int[] len = new int[nums.length];
        len[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int tc = 1;
            pre[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && len[j] + 1 > tc) {
                    tc = len[j] + 1;
                    pre[i] = j;
                }
            }
            len[i] = tc;

        }
        int max = 1, pos = 0;
        for (int i = 1; i < nums.length; i++) {
            if (len[i] > max) {
                max = len[i];
                pos = i;
            }
        }
        LinkedList<Integer> result = new LinkedList<Integer>();
        while (pos != pre[pos]){
            result.addFirst(nums[pos]);
            pos = pre[pos];
        }
        result.addFirst(nums[pos]);

        return result;
    }

    public static void main(String[] args) {
        for (Integer i : new Solution().largestDivisibleSubset(new int[]{2})) {
            System.out.println(i);
        }
    }
}
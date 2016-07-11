import java.util.*;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> count1 = new HashSet<>();
        for (int i : nums1)
            count1.add(i);
        List<Integer> list = new LinkedList<>();
        for (int i : nums2) {
            if (count1.contains(i)) {
                count1.remove(i);
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        int pos = 0;
        for (int i : list)
            res[pos++] = i;
        return res;
    }

    public static void main(String[] args) {
    }
}
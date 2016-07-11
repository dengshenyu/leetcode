import java.util.*;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> count1 = new HashMap<Integer, Integer>();
        for (int i : nums1) {
            Integer n = count1.get(i);
            if (n == null)
                n = 1;
            else
                n++;
            count1.put(i, n);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int j : nums2) {
            Integer n = count1.get(j);
            if (n != null) {
                res.add(j);
                n--;
                if (n == 0)
                    count1.remove(j);
                else
                    count1.put(j, n);
            }
        }
        int[] a = new int[res.size()];
        int pos = 0;
        for (Integer i : res)
            a[pos++] = i;
        return a;
    }

    public static void main(String[] args) {
    }
}
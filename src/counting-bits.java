import java.util.*;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {
    public int[] countBits(int num) {
        if (num == 0)
            return new int[]{0};
        if (num == 1)
            return new int[]{0, 1};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        int cur = 2, before = 1;
        int curBak;
        while (cur <= num) {
            curBak = cur;
            int end = cur - 1;
            for (int i = before; i <= end && cur <= num; i++) {
                list.add(list.get(i));
                cur++;
            }
            for (int i = before; i <= end && cur <= num; i++) {
                list.add(list.get(i) + 1);
                cur++;
            }
            before = curBak;
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = list.get(i);
        return result;
    }
}
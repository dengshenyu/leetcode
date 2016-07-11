import java.util.*;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {
    private void sort(int[][] a, int left, int right) {
        if (right <= left)
            return;
        int i = left, j = right - 1;
        while (i <= j) {
            while (i <= j && compare(a[i], a[right]) < 0)
                i++;
            while (i <= j && compare(a[j], a[right]) > 0)
                j--;
            if (i <= j) {
                int[] t = a[i];
                a[i] = a[j];
                a[j] = t;
                i++;
                j--;
            }
        }
        int[] t = a[right];
        a[right] = a[i];
        a[i] = t;
        sort(a, left, i-1);
        sort(a, i+1, right);
    }

    private int compare(int[] a, int[] b) {
        if (a[0] < b[0])
            return -1;
        else if (a[0] > b[0])
            return 1;

        if (a[1] < b[1])
            return -1;
        else if (a[1] > b[1])
            return 1;

        return 0;
    }
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0)
            return 0;
        sort(envelopes, 0, envelopes.length - 1);
        int[] res = new int[envelopes.length];
        res[0] = 1;
        int max = res[0];
        for (int i = 1; i < envelopes.length; i++) {
            int m = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1] && res[j] + 1 > m)
                    m = res[j] + 1;
            }
            res[i] = m;
            if (m > max)
                max = m;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
    }
}
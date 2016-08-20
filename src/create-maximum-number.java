import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {
    //private short[][][] d;
    private Map<Integer, Integer> d = new HashMap<Integer, Integer>();
    private int k, n, m;
    private int[] nums1, nums2;
    private short[][] mx1, mx2;

    private Integer getKey(int a, int b, int c) {
        return (a << 20) | (b << 10) | c;
    }

    private void calMax(int i, int j, int l) {
        if (l == 0)
            return;
        Integer key = getKey(i, j, l);
        if (d.containsKey(key))
            return;
        if (i < n && j >= m) {
            int r = (n+m-j-l) < n ? (n+m-j-l) : (n-1);
            calMax(mx1[i][r]+1, j, l-1);
            d.put(key, mx1[i][r]+1);
        } else if (j < m && i >= n) {
            int r = n-i+m-l < m ? n-i+m-l : m-1;
            calMax(i, mx2[j][r]+1, l-1);
            d.put(key, n + mx2[j][r] + 1);
        } else {
            int r1 = (n+m-j-l) < n ? (n+m-j-l) : (n-1);
            int r2 = n-i+m-l < m ? n-i+m-l : m-1;
            if (nums1[mx1[i][r1]] > nums2[mx2[j][r2]]) {
                calMax(mx1[i][r1]+1, j, l-1);
                d.put(key, mx1[i][r1]+1);
            } else if (nums1[mx1[i][r1]] < nums2[mx2[j][r2]]) {
                calMax(i, mx2[j][r2]+1, l-1);
                d.put(key, n + mx2[j][r2] + 1);
            } else {
                calMax(mx1[i][r1]+1, j, l-1);
                calMax(i, mx2[j][r2]+1, l-1);
                if (isBigger(mx1[i][r1]+1, j, i, mx2[j][r2]+1, l-1))
                    d.put(key, mx1[i][r1]+1);
                else
                    d.put(key, n + mx2[j][r2] + 1);
            }
        }
        /*
        if (i < n) {
            int r = (n+m-j-l) < n ? (n+m-j-l) : (n-1);
            calMax(mx1[i][r]+1, j, l-1);
            d.put(key, mx1[i][r]+1);
        }
        if (j < m){
            Integer value = d.get(key);
            int r = n-i+m-l < m ? n-i+m-l : m-1;
            if (!d.containsKey(key) || nums2[mx2[j][r]] > nums1[value-1]) {
                calMax(i, mx2[j][r]+1, l-1);
                d.put(key, n + mx2[j][r] + 1);
            } else if (nums2[mx2[j][r]] == nums1[value-1]) {
                calMax(i, mx2[j][r]+1, l-1);
                if (isBigger(i, mx2[j][r]+1, value, j, l-1))
                    d.put(key, n + mx2[j][r] + 1);
            }
        }
        */
    }

    private boolean isBigger(int a1, int a2, int b1, int b2, int len) {
        if (len == 0)
            return true;
        int t1, t2;
        Integer key1 = getKey(a1, a2, len);
        Integer value1 = d.get(key1);
        Integer key2 = getKey(b1, b2, len);
        Integer value2 = d.get(key2);
        if (value1 <= n) {
            t1 = nums1[value1 - 1];
            a1 = value1;
        } else {
            t1 = nums2[value1 - n - 1];
            a2 = value1 - n;
        }
        if (value2 <= n) {
            t2 = nums1[value2 - 1];
            b1 = value2;
        } else {
            t2 = nums2[value2 - n - 1];
            b2 = value2 - n;
        }
        if (t1 > t2)
            return true;
        else if (t1 < t2)
            return  false;
        else
            return isBigger(a1, a2, b1, b2, len-1);
    }

    private void calMx() {
        mx1 = new short[n][n];
        mx2 = new short[m][m];
        for (short i = 0; i < n; i++) {
            for (short j = i; j < n; j++) {
                if (j == i) {
                    mx1[i][j] = i;
                } else {
                    if (nums1[j] > nums1[mx1[i][j-1]])
                        mx1[i][j] = j;
                    else
                        mx1[i][j] = mx1[i][j-1];
                }
            }
        }
        for (short i = 0; i < m; i++) {
            for (short j = i; j < m; j++) {
                if (j == i) {
                    mx2[i][j] = i;
                } else {
                    if (nums2[j] > nums2[mx2[i][j-1]])
                        mx2[i][j] = j;
                    else
                        mx2[i][j] = mx2[i][j-1];
                }
            }
        }
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        //d = new short[nums1.length+1][nums2.length+1][k+1];
        this.k = k;
        this.nums1 = nums1;
        this.nums2 = nums2;
        n = nums1.length;
        m = nums2.length;
        calMx();
        int[] ans = new int[k];
        calMax(0, 0, k);
        int pos = 0, a = 0, b = 0;
        while (k > 0) {
            Integer key = getKey(a, b, k);
            int t = d.get(key);
            if (t <= n) {
                ans[pos++] = nums1[t - 1];
                a = t;
            } else {
                ans[pos++] = nums2[t - n - 1];
                b = t - n;
            }
            k--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ans = new Solution().maxNumber(new int[]{2,5,6,4,4,0}, new int[]{7,3,8,0,6,5,7,6,2}, 15);
        for (int i = 0; i < ans.length; i++)
            System.out.print(ans[i] + " ");
        //[]
    }
}
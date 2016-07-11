import java.util.*;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] recsum = new int[n];
        int[] rowsum = new int[n];

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(recsum, 0);
                for (int p = i; p < m; p++) {
                    Arrays.fill(rowsum, 0);
                    for (int q = j; q < n; q++) {
                        int sum = recsum[q] + matrix[p][q]+ (q > j ? rowsum[q-1] : 0);
                        if (sum <= k && sum > result)
                            result = sum;
                        rowsum[q] = matrix[p][q] + (q > j ? rowsum[q-1] : 0);
                        recsum[q] = sum;
                    }
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().maxSumSubmatrix(new int[][]{{1, 0, 1}, {0, -2, 3}}, 2));
    }


}
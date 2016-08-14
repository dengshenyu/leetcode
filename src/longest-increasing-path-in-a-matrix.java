import java.util.*;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {
    Map<String, Integer> counter = new HashMap<>();

    private int longestPath(int[][] matrix, int i, int j) {
        String key = i + "," + j;
        if (counter.containsKey(key))
            return counter.get(key);
        int longest = 0;
        int tmp;
        if (i - 1 >= 0 && matrix[i-1][j] > matrix[i][j]) {
            tmp = longestPath(matrix, i-1, j);
            if (tmp > longest)
                longest = tmp;
        }
        if (i + 1 < matrix.length && matrix[i+1][j] > matrix[i][j]) {
            tmp = longestPath(matrix, i+1, j);
            if (tmp > longest)
                longest = tmp;
        }
        if (j - 1 >= 0 && matrix[i][j-1] > matrix[i][j]) {
            tmp = longestPath(matrix, i, j-1);
            if (tmp >longest)
                longest = tmp;
        }
        if (j + 1 < matrix[i].length && matrix[i][j+1] > matrix[i][j]) {
            tmp = longestPath(matrix, i, j+1);
            if (tmp > longest)
                longest = tmp;
        }
        longest++;
        counter.put(key, longest);
        return longest;
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (longestPath(matrix, i, j) > max)
                    max = longestPath(matrix, i, j);
            }
        }
        return max;
    }

    public static void main(String[] args) {
    }
}
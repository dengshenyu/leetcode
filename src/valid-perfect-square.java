import java.util.*;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {
    public boolean isPerfectSquare(int num) {
        long t = num;
        long left = 1, right = t;
        while (left <= right) {
            long middle = (left + right) / 2;
            long tmp = middle * middle;
            if (tmp == t) {
                return true;
            } else if (tmp > t) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return false;
    }
}
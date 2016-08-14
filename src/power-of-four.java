import java.util.*;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {
    public boolean isPowerOfFour(int num) {
        if (num <= 0)
            return false;
        while (num != 1) {
            if (num % 4 != 0)
                return false;
            num /= 4;
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
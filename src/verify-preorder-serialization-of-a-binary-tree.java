import java.util.*;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {
    public int isValidSerialization(String[] preorders, int pos) {
        if (preorders[pos].equals("#"))
            return pos;
        if (pos + 1 >= preorders.length)
            return -1;
        int leftMost = isValidSerialization(preorders, pos + 1);
        if (leftMost == -1 || leftMost + 1 >= preorders.length)
            return -1;
        return isValidSerialization(preorders, leftMost + 1);
    }

    public boolean isValidSerialization(String preorder) {
        String[] preorders = preorder.split(",");
        return (preorder.isEmpty() || isValidSerialization(preorders, 0) == preorders.length - 1) ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValidSerialization("#,1"));
    }
}
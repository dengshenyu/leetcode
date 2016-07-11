import java.util.*;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {

    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
            i++;
            j--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseString("hello"));
    }
}
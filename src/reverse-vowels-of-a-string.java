import java.util.*;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !isVowel(chars[i]))
                i++;
            while (i < j && !isVowel(chars[j]))
                j--;
            if (i < j) {
                char t = chars[i];
                chars[i] = chars[j];
                chars[j] = t;
                i++;
                j--;
            }
        }
        return new String(chars);
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'A'
                || c == 'e' || c == 'E'
                || c == 'i' || c == 'I'
                || c == 'o' || c == 'O'
                || c == 'u' || c == 'U';
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("hello"));
    }
}
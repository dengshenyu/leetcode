import java.util.*;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> resultList = new ArrayList<>();
        Map<String, Integer> wordIndex = new HashMap<>();
        for (int i = 0; i < words.length; i++)
            wordIndex.put(words[i], i);
        for (int i = 0; i < words.length; i++) {
            int l = 0;
            int r = 0;
            while (l <= r) {
                String reverse = new StringBuilder(words[i].substring(l, r)).reverse().toString();
                Integer j = wordIndex.get(reverse);
                if (j != null && i != j) {
                    if (l == 0 && isPalindrome(words[i].substring(r))) {
                        resultList.add(Arrays.asList(new Integer[]{i, j}));
                    } else if (r == words[i].length() && isPalindrome(words[i].substring(0, l))) {
                        resultList.add(Arrays.asList(new Integer[]{j, i}));
                    }
                }
                if (r < words[i].length())
                    r++;
                else
                    l++;
            }
        }
        return resultList;
    }
    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }

}
import java.net.Socket;
import java.util.*;

/**
 * Created by shenyuan on 17/2/22.
 */
public class Solution {
    public String findLongestWord(String s, List<String> d) {


        Collections.sort(d, new Comparator<String>() {
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length())
                    return o1.compareTo(o2);
                else if (o1.length() > o2.length())
                    return -1;
                else
                    return 1;
            }
        });

        for (int i = 0; i < d.size(); i++) {
            String target = d.get(i);
            if (check(s, target))
                return target;
        }
        return "";
    }

    private static boolean check(String a, String b) {
        if (a.length() < b.length())
            return false;
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        if (j == b.length())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("ale");
        list.add("apple");
        System.out.println(new Solution().findLongestWord("abpcplea", list));
    }
}
package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> dup = new HashSet<Character>();
        int i = 0, j = 0;
        int result = 0;
        while (true) {
        	while ( j < s.length() && !dup.contains(s.charAt(j))) {
        		dup.add(s.charAt(j));
        		j++;
        	}
        	if (j - i > result)
        		result = j - i;
        	if (j == s.length())
        		return result;
        	dup.remove(s.charAt(i));
        	i++;
        }
    }
}

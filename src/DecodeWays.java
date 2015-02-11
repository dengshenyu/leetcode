package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;




public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty())
        	return 0;
        int[] result = new int[s.length()+1];
        result[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
        	int count = 0;
        	if (s.charAt(i) != '0') {
        		count += result[i + 1];
        	}
        	if (s.length() - i >= 2 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6')))
        		count += result[i + 2];
        	result[i] = count;
        }
        return result[0];
    }
}

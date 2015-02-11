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
    public List<String> fullJustify(String[] words, int L) {
        int i = 0;
        LinkedList<String> result = new LinkedList<String>();
        int begin = 0;
        int remain = L;
        int wordsLen = 0;
        //boolean first = true;
        while (i < words.length) {
        	if (i == begin) {
        		remain -= words[i].length();
        		wordsLen += words[i].length();
        		i++;
        	} else {
        		if (remain >= words[i].length() + 1) {
        			remain -= ( words[i].length() + 1);
        			wordsLen += words[i].length();
        			i++;
        		} else {
        			if (i - begin == 1) {
        				//result.add(words[begin]);
        				StringBuilder w = new StringBuilder(words[begin]);
        				for (int j = 1; j <= L - wordsLen; j++)
        					w.append(" ");
        				result.add(w.toString());
        			} else {
        				
        				int spaces = L - wordsLen;
        				int n = i - begin - 1;
        				int f = spaces / n;
        				int r = spaces % n;
        				StringBuilder w = new StringBuilder();
        				for (int j = 1; j <= n; j++) {
        					w.append(words[begin++]);
        					if (j <= r) {
        						for (int k = 1; k <= f + 1; k++)
        							w.append(" ");
        					} else {
        						for (int k = 1; k <= f; k++)
        							w.append(" ");
        					}
        				}
        				w.append(words[begin]);
        				result.add(w.toString());
        			}
        			
        			begin = i;
        			wordsLen = 0;
        			remain = L;
        		}
        	}
        }
        StringBuilder w = new StringBuilder(words[begin++]);
        while (begin < words.length) {
        	w.append(" ");
        	w.append(words[begin++]);
        }
        for (int j = 1; j <= remain; j++)
        	w.append(" ");
        result.add(w.toString());
        return result;
    }
    public static void main(String[] args) {
    	List<String> a = new Solution().fullJustify(new String[]{"a","b","c","d","e"}, 3);
    	System.out.println(a.size());
    }
}

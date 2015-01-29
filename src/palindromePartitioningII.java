package leetcode;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;




public class Solution {
    public int minCut(String s) {
    	int[] cuts = new int[s.length()];
    	boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
        	cuts[i] = i;
        	for (int j = 0; j <= i; j++) {
        		if (s.charAt(j) == s.charAt(i) && (j+1 >= i-1 || isPalindrome[j+1][i-1]))
        			isPalindrome[j][i] = true;
        		if (j > 0 && isPalindrome[j][i] && cuts[j-1] + 1 < cuts[i])
        			cuts[i] = cuts[j-1] + 1;
        		if (j == 0 && isPalindrome[j][i])
        			cuts[i] = 0;
        	}
        }
        return cuts[s.length()-1];
    }
}



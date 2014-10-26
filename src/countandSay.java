package test.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public String countAndSay(int n) {
    	String cur = "1";
        for (int i = 2; i <= n; i++) {
        	StringBuilder curBuild = new StringBuilder();
        	int begin = -1;
        	for (int j = 0; j < cur.length(); j++) {
        		if (j == 0)
        			begin = j;
        		else if (j > 0 && cur.charAt(j) != cur.charAt(j - 1)) {
        			int len = j - begin;
        			curBuild.append(String.valueOf(len));
        			curBuild.append(cur.charAt(j - 1));
        			begin = j;
        		}
        	}
        	if (begin != -1) {
        		curBuild.append(String.valueOf(cur.length() - begin));
        		curBuild.append(cur.charAt(cur.length() - 1));
        	}
        	cur = curBuild.toString();
        }
        return cur;
    }
}

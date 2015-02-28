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
    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length() + 1];
        int s, k = -1;
        for (int i = num2.length() - 1; i >= 0; i--) {
        	k++;
        	int pos = k;
        	for (int j = num1.length() - 1; j >= 0; j--) {
        		s = (num1.charAt(j) - '0') * (num2.charAt(i) - '0');
        		result[pos++] += s;
        	}
        }
        k = 0;
        while (k < result.length) {
        	if (result[k] >= 10) {
        		result[k+1] += result[k] / 10;
        		result[k] %= 10;
        	}
        	k++;
        }
        k = result.length - 1;
        while (k >= 0 && result[k] == 0)
        	k--;
        if (k < 0)
        	return "0";
        StringBuilder sb = new StringBuilder();
        while (k >= 0) {
        	sb.append(result[k]);
        	k--;
        }
        return sb.toString();
    }
}

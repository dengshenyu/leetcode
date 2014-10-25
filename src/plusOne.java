package test.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
        	return digits;
        int plus = 1;
        int curPos = digits.length - 1;
        while (plus == 1 && curPos >= 0) {
        	digits[curPos] += 1;
        	if (digits[curPos] >= 10)
        		digits[curPos] -= 10;
        	else
        		plus = 0;
        	curPos--;
        }
        if (plus == 0) {
        	return digits;
        } else {
        	int[] result = new int[digits.length + 1];
        	result[0] = 1;
        	int len = result.length;
        	for (int i = 1; i < len; i++) 
        		result[i] = digits[i - 1];
        	return result;
        }
    }
}

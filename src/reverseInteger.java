package test.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Solution {
    public int reverse(int x) {
        long absResult = 0;
        long absX = x;
        boolean positive = true;
        if (x < 0) {
        	positive = false;
        	absX = absX * -1;
        }
        while (absX != 0) {
        	int cur = (int)(absX % 10);
        	if (positive) {
        		if (absResult <= (Integer.MAX_VALUE - cur) / 10)
        			absResult = absResult * 10 + cur;
        		else
        			absResult = Integer.MAX_VALUE;
        	} else {
        		if (absResult <= (Integer.MIN_VALUE * (long)-1 - cur) / 10)
        			absResult = absResult * 10 + cur;
        		else
        			absResult = Integer.MIN_VALUE * (long)-1;
        	}
        	absX /= 10;
        }
        if (positive)
        	return (int)absResult;
        else
        	return (int)(absResult * -1);
    }
}

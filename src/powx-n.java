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
    public double pow(double x, int n) {
        if (n == 0)
        	return 1;
        double a = (x >= 0) ? x : -x;
        long b = (n > 0) ? n : (long)n * -1;
        double v = powAbs(a, b);
        if (x < 0 && b % 2 ==1)
        	v = -v;
        if (n < 0)
        	v = 1 / v;
        return v;
    }
    private double powAbs(double a, long b) {
    	double d = a;
    	double result = 1;
    	while (b != 0) {
    		if ((b & 1) == 1)
    			result *= d;
    		b = b >> 1;
    		d *= d;
    	}
    	return result;
    }
}

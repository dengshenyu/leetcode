package test.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int climbStairs(int n) {
        if (n == 1 || n == 0)
        	return 1;
        int nMinus2 = 1, nMinus1 = 1;
        int cur = 0;
        for (int i = 2; i <= n; i++) {
        	cur = nMinus2 + nMinus1;
        	nMinus2 = nMinus1;
        	nMinus1 = cur;
        }
        return cur;
    }
}

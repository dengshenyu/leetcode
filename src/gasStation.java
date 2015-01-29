package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;


public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int reach = 0, tankGas = 0, travelCost = 0;
        int i = 0;
        while (true) {
        	while (true) {
            	if (tankGas + gas[reach] >= travelCost + cost[reach]) {
            		tankGas += gas[reach];
            		travelCost += cost[reach];
            		reach = (reach + 1) % gas.length;
            	} else
            		break;
            	if (reach == i)
            		return i;
        	}
        	
        	if (tankGas > 0) {
        		tankGas -= gas[i];
        		travelCost -= cost[i];
        	}
        	if (reach == i)
        		reach = (reach + 1) % gas.length;
        	i = (i + 1) % gas.length;
        	if (i == 0)
        		return -1;
        }
    }
}

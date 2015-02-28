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
	class Entry {
		int x,y;
		Entry(int tx, int ty){x = tx; y = ty;}
	}
    public int maxArea(int[] height) {
    	int maxIndex = -1;
    	int maxHeight = -1;
    	ArrayList<Entry> list = new ArrayList<Entry>();
    	for(int i = 0; i < height.length; i++) {
    		Entry entry = new Entry(i, height[i]);
    		if (maxIndex == -1) {
    			list.add(entry);
    			maxIndex = 0;
    			maxHeight = height[i];
    		} else {
    			if (height[i] < height[i-1]) {
    				list.add(entry);
    			} else {
    				int j = list.size() - 1;
    				while (j != maxIndex) {
    					if (list.get(j).y <= height[i])
    						list.remove(j);
    					else
    						break;
    					j--;
    				}
    				list.add(entry);
    				if (height[i] > maxHeight) {
    					maxIndex = list.size() - 1;
    					maxHeight = height[i];
    				}
    			}
    		}
    	}
    	int result = 0;
    	for (int i = 0; i < list.size(); i++) {
    		if (maxIndex > i) {
    			int j = maxIndex;
    			while (j < list.size()) {
    				int h = list.get(i).y > list.get(j).y ? list.get(j).y : list.get(i).y;
    				int area = h * (list.get(j).x - list.get(i).x);
    				if (area > result)
    					result = area;
    				j++;
    			}
    		} else if (maxIndex < i) {
    			int j = maxIndex;
    			while (j >= 0) {
    				int h = list.get(i).y > list.get(j).y ? list.get(j).y : list.get(i).y;
    				int area = h * (list.get(i).x - list.get(j).x);
    				if (area > result)
    					result = area;
    				j--;
    			}
    		}
    	}
    	return result;
    }
}

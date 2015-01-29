package leetcode;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0)
        	return null;
        return sortedArrayToBST(num, 0, num.length - 1);
    }
    private TreeNode sortedArrayToBST(int[] num, int begin, int end) {
    	if (begin > end)
    		return null;
    	else if (begin == end)
    		return new TreeNode(num[begin]);
    	else {
    		int middle = (begin + end) / 2;
    		TreeNode root = new TreeNode(num[middle]);
    		TreeNode left = sortedArrayToBST(num, begin, middle - 1);
    		TreeNode right = sortedArrayToBST(num, middle + 1, end);
    		root.left = left;
    		root.right = right;
    		return root;
    	}
    }
}



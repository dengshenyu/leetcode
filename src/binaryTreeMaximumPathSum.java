package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int maxPathSum(TreeNode root) {
    	int[] maxes = new int[2];
        maxPathSum(root, maxes);
        return maxes[0];
    }
    private void maxPathSum(TreeNode root, int[] maxes) {
    	maxes[0] = root.val;
    	maxes[1] = root.val;
    	int maxPathViaRoot = root.val;
    	if (root.left != null) {
    		int[] ld = new int[2];
    		maxPathSum(root.left, ld);
    		if (ld[0] > maxes[0])
    			maxes[0] = ld[0];
    		if (ld[1] > 0) {
    			maxes[1] = ld[1] + root.val;
    			maxPathViaRoot += ld[1];
    		}
    	}
    	if (root.right != null) {
    		int[] ld = new int[2];
    		maxPathSum(root.right, ld);
    		if (ld[0] > maxes[0])
    			maxes[0] = ld[0];
    		if (ld[1] > 0) {
    			maxPathViaRoot += ld[1];
    			if (ld[1] + root.val > maxes[1])
    				maxes[1] = ld[1] + root.val;
    		}
    	}
    	if (maxPathViaRoot > maxes[0])
    		maxes[0] = maxPathViaRoot;
    }
}

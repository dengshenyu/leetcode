package test.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left, right;
	TreeNode(){left = null; right = null;}
}


public class Solution {
    public int maxDepth(TreeNode root) {
    	if (root == null)
    		return 0;
    	int leftDepth = 0, rightDepth = 0;
    	if (root.left == null && root.right == null)
    		return 1;
    	else {
    		if (root.left != null)
    			leftDepth = maxDepth(root.left);
    		if (root.right != null)
    			rightDepth = maxDepth(root.right);
    		return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
    	}
    }
}

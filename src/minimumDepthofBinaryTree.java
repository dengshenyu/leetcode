package test.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left, right;
	TreeNode(){left = null; right = null;}
}


public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
        	return 0;
        return dfsFindMin(root, 0, Integer.MAX_VALUE);
    }
    private int dfsFindMin(TreeNode curNode, int depth, int minFound) {
    	if (curNode.left == null && curNode.right == null)
    		minFound = (depth + 1 < minFound) ? depth + 1 : minFound;
    	if (curNode.left != null)
    		minFound = dfsFindMin(curNode.left, depth + 1, minFound);
    	if (curNode.right != null)
    		minFound = dfsFindMin(curNode.right, depth + 1, minFound);
    	return minFound;
    }
}

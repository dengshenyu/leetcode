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
    public boolean isBalanced(TreeNode root) {
    	if (root == null)
    		return true;
    	return isBalancedWithHeight(root, new int[]{0});
    }
    private boolean isBalancedWithHeight(TreeNode curNode, int[] height) {
    	int leftHeight = 0 , rightHeight = 0;
    	if (curNode.left != null) {
    		if (!isBalancedWithHeight(curNode.left, height))
    			return false;
    		leftHeight = height[0];
    	}
    	if (curNode.right != null) {
    		if (!isBalancedWithHeight(curNode.right, height))
    			return false;
    		rightHeight = height[0];
    	} 
    	if ((leftHeight - rightHeight > 1) || (leftHeight - rightHeight < -1))
    		return false;
    	height[0] = (leftHeight > rightHeight) ? (leftHeight + 1) : (rightHeight + 1);
    	return true;
    }
}

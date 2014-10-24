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
    public boolean hasPathSum(TreeNode root, int sum) {
    	if (root == null)
    		return false;
        return DFS(root, 0, sum);
    }
    
    private boolean DFS(TreeNode curNode, int preSum, int sum) {
    	if (curNode.left != null && DFS(curNode.left, preSum + curNode.val, sum))
    		return true;
    	else if (curNode.right != null && DFS(curNode.right, preSum + curNode.val, sum))
    		return true;
    	else if (curNode.left == null && curNode.right == null)
    		return (preSum + curNode.val == sum);
    	else
    		return false;
    }
}

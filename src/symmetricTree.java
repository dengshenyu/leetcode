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
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
        	return true;
        return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode leftChild, TreeNode rightChild) {
    	if (leftChild == null && rightChild == null)
    		return true;
    	else if (leftChild == null && rightChild != null)
    		return false;
    	else if (rightChild == null && leftChild != null)
    		return false;
    	else {
    		if (leftChild.val != rightChild.val)
    			return false;
    		return isSymmetric(leftChild.left, rightChild.right) && 
    			   isSymmetric(leftChild.right, rightChild.left);
    	}
    }
}

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	if (inorder == null || inorder.length == 0)
    		return null;
    	return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode buildTree(int[] inorder, int inBegin, int inEnd, 
    		int[] postorder, int postBegin, int postEnd) {
    	if (inBegin > inEnd)
    		return null;
    	else if (inBegin == inEnd)
    		return new TreeNode(inorder[inBegin]);
    	else {
    		TreeNode root = new TreeNode(postorder[postEnd]);
    		int i;
    		for (i = inBegin; i<= inEnd; i++) {
    			if (inorder[i] == postorder[postEnd])
    				break; // root in inorder
    		}
    		int leftLen = i - inBegin;
    		int rightLen = inEnd - i;
    		if (leftLen > 0) {
    			TreeNode left = buildTree(inorder, inBegin, i - 1, postorder, 
    					postBegin, postBegin + leftLen - 1);
    			root.left = left;
    		}
    		if (rightLen > 0) {
    			TreeNode right = buildTree(inorder, i + 1, inEnd, postorder,
    					postEnd - rightLen, postEnd - 1);
    			root.right = right;
    		}
    		return root;
    	}
    }
}



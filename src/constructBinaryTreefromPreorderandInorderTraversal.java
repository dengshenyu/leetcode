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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if (preorder == null || preorder.length == 0)
    		return null;
    	return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    private TreeNode buildTree(int[] preorder, int preBegin, int preEnd, int[] inorder,
    		int inBegin, int inEnd) {
    	if (preBegin > preEnd)
    		return null;
    	else if (preBegin == preEnd)
    		return new TreeNode(preorder[preBegin]);
    	else {
    		TreeNode root = new TreeNode(preorder[preBegin]);
    		int i;
    		for (i = inBegin; i <= inEnd; i++) {
    			if (preorder[preBegin] == inorder[i])
    				break;
    		}
    		int leftLen = i - inBegin;
    		int rightLen = inEnd - i;
    		if (leftLen > 0) {
    			TreeNode left = buildTree(preorder, preBegin + 1, preBegin + leftLen, 
    					inorder, inBegin, i - 1);
    			root.left = left;
    		}
    		if (rightLen > 0) {
    			TreeNode right = buildTree(preorder, preEnd - rightLen + 1 , preEnd, 
    					inorder, i + 1, inEnd);
    			root.right = right;
    		}
    		return root;
    	}
    	
    }
    
}



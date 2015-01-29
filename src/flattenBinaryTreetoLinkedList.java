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
    public void flatten(TreeNode root) {
        if (root == null)
        	return;
        flattenAndReturnRightMost(root);
    }
    
    private TreeNode flattenAndReturnRightMost(TreeNode root) {
    	if (root.left != null && root.right != null) {
    		TreeNode tmp = flattenAndReturnRightMost(root.left);
    		tmp.right = root.right;
    		root.right = root.left;
    		root.left = null;
    		return flattenAndReturnRightMost(tmp.right);
    	} else if (root.left != null && root.right == null) {
    		TreeNode tmp = flattenAndReturnRightMost(root.left);
    		root.right = root.left;
    		root.left = null;
    		return tmp;
    	} else if (root.left == null && root.right != null) {
    		return flattenAndReturnRightMost(root.right);
    	} else {
    		return root;
    	}
    }
}



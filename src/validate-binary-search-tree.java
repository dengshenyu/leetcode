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
    public boolean isValidBST(TreeNode root) {
    	return isVaildBSTAndMinMax(root, new TreeNode[2]);
    }
    private boolean isVaildBSTAndMinMax(TreeNode root, TreeNode[] minAndMax) {
    	minAndMax[0] = root;
    	minAndMax[1] = root;
        if (root == null || (root.left == null && root.right == null))
        	return true;
        if (root.left != null) {
        	TreeNode[] leftMinAndMax = new TreeNode[2];
        	if (!isVaildBSTAndMinMax(root.left, leftMinAndMax))
        		return false;
        	if (leftMinAndMax[1].val >= root.val)
        		return false;
        	minAndMax[0] = leftMinAndMax[0];
        }
        if (root.right != null) {
        	TreeNode[] rightMinAndMax = new TreeNode[2];
        	if (!isVaildBSTAndMinMax(root.right, rightMinAndMax))
        		return false;
        	if (rightMinAndMax[0].val <= root.val)
        		return false;
        	minAndMax[1] = rightMinAndMax[1];
        }
        return true;
    }
}



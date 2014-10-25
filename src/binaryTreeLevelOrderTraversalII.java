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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	if (root == null)
    		return new LinkedList<List<Integer>>();
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        LinkedList<TreeNode> curLevel = new LinkedList<TreeNode>();
        curLevel.add(root);
        LinkedList<TreeNode> nextLevel = null;
        while (!curLevel.isEmpty()) {
        	nextLevel = new LinkedList<TreeNode>();
        	LinkedList<Integer> curResult = new LinkedList<Integer>();
        	Iterator<TreeNode> it = curLevel.iterator();
        	while (it.hasNext()) {
        		TreeNode node = it.next();
        		curResult.add(node.val);
        		if (node.left != null)
        			nextLevel.add(node.left);
        		if (node.right != null)
        			nextLevel.add(node.right);
        	}
        	result.add(curResult);
        	curLevel = nextLevel;
        }
        Collections.reverse(result);
        return result;
    }
}

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
	private LinkedList<Integer> path = new LinkedList<Integer>();
	private LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	if (root == null)
    		return result;
    	pathSum(root, 0, sum);
    	return result;
    }
    private void pathSum(TreeNode root, int parentSum, int sum) {
    	if (root.left == null && root.right == null) {
    		if (parentSum + root.val == sum) {
    			LinkedList<Integer> r = new LinkedList<Integer>();
    			for (Integer i : path) {
    				r.add(i);
    			}
    			r.add(root.val);
    			result.add(r);
    		}
    		return;
    	} else {
    		if (root.left != null) {
    			path.add(root.val);
    			pathSum(root.left, parentSum + root.val, sum);
    			path.pollLast();
    		}
    		if (root.right != null) {
    			path.add(root.val);
    			pathSum(root.right, parentSum + root.val, sum);
    			path.pollLast();
    		}
    	}
    }
}



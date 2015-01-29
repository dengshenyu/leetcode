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
    TreeNode(int x) { val = x; left = null; right = null; }
}


public class Solution {
    public List<TreeNode> generateTrees(int n) {
    	return generateTrees(1, n);
    }
    private List<TreeNode> generateTrees(int begin, int end) {
    	if (end < begin) {
    		LinkedList<TreeNode> t = new LinkedList<TreeNode>();
    		t.add(null);
    		return t;
    	} else if (end == begin) {
    		LinkedList<TreeNode> t = new LinkedList<TreeNode>();
    		t.add(new TreeNode(begin));
    		return t;
    	} else {
    		LinkedList<TreeNode> t = new LinkedList<TreeNode>();
    		for (int i = begin; i <= end; i++) {
    			for (TreeNode leftSubTree : generateTrees(begin, i-1)) {
    				for (TreeNode rightSubTree : generateTrees(i+1, end)) {
    					TreeNode cur = new TreeNode(i);
    					cur.left = leftSubTree;
    					cur.right = rightSubTree;
    					t.add(cur);
    				}
    			}
    		}
    		return t;
    	}
    }
}



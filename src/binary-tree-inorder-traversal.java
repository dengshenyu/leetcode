package leetcode;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
    public List<Integer> inorderTraversal(TreeNode root) {
    	LinkedList<Integer> result = new LinkedList<Integer>();
    	if (root == null)
    		return result;
    	HashSet<TreeNode> isVisited = new HashSet<TreeNode>();
    	LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
    	nodeList.add(root);
    	while (!nodeList.isEmpty()) {
    		TreeNode cur = nodeList.pollFirst();
    		if (!isVisited.contains(cur)) {
    			isVisited.add(cur);
    			if (cur.right != null)
    				nodeList.addFirst(cur.right);
    			nodeList.addFirst(cur);
    			if (cur.left != null)
    				nodeList.addFirst(cur.left);
    		} else {
    			result.add(cur.val);
    		}
    	}
    	return result;
    }
}



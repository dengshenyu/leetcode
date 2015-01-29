package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
    	if (root == null)
    		return new LinkedList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        LinkedList<Integer> result = new LinkedList<Integer>();
        HashMap<TreeNode, Boolean> visited = new HashMap<TreeNode, Boolean>();
        stack.add(root);
        while (!stack.isEmpty()) {
        	TreeNode top = stack.peek();
        	if (!visited.containsKey(top)) {
        		visited.put(top, true);
        		if (top.right != null)
        			stack.addFirst(top.right);
        		if (top.left != null)
        			stack.addFirst(top.left);
        	} else {
        		result.add(top.val);
        		stack.poll();
        	}
        }
        return result;
    }
}

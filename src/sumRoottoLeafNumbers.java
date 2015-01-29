package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0, 0);
    }
    
    public int sumNumbers(TreeNode cur, int preNum, int result) {
    	if (cur == null)
    		return result;
    	if (cur.left == null && cur.right == null) {
    		return result + preNum * 10 + cur.val;
    	}
    	if (cur.left != null) {
    		result = sumNumbers(cur.left, preNum * 10 + cur.val, result);
    	}
    	if (cur.right != null) {
    		result = sumNumbers(cur.right, preNum * 10 + cur.val, result);
    	}
    	return result;
    }
}

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
        	return true;
        else if (p == null && q != null)
        	return false;
        else if (q == null && p != null)
        	return false;
        else {
        	if (p.val != q.val)
        		return false;
        	return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}

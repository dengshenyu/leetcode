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
	class Node {
		int largeIndex;
		TreeNode large, small;
		Node(int lIndex, TreeNode l, TreeNode s){largeIndex = lIndex; large = l; small = s;}
	}
	int index;
	LinkedList<Node> swapped;
    public void recoverTree(TreeNode root) {
    	swapped = new LinkedList<Node>();
    	index = 0;
        findSwapped(root, new TreeNode[2]);
        TreeNode first, second;
        if (swapped.size() == 1) {
        	Node n = swapped.poll();
        	first = n.large;
        	second = n.small;
        } else {
            Node n1 = swapped.poll();
            Node n2 = swapped.poll();
            if (n1.largeIndex < n2.largeIndex) {
            	first = n1.large;
            	second = n2.small;
            } else {
            	first = n2.large;
            	second = n1.small;
            }
        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    private void findSwapped(TreeNode root, TreeNode[] minAndMax) {
		minAndMax[0] = root;
		minAndMax[1] = root;
    	if (root.left == null && root.right == null) {
    		index++;
    		return;
    	}
    	if (root.left != null) {
    		TreeNode[] leftMinAndMax = new TreeNode[2];
    		findSwapped(root.left, leftMinAndMax);
    		if (leftMinAndMax[1].val > root.val) {
    			swapped.add(new Node(index-1, leftMinAndMax[1], root));
    		}
    		minAndMax[0] = leftMinAndMax[0];
    	}
    	int curIndex = index;
    	index++; //next index

    	if (root.right != null) {
    		TreeNode[] rightMinAndMax = new TreeNode[2];
    		findSwapped(root.right, rightMinAndMax);
    		if (rightMinAndMax[0].val < root.val) {
    			swapped.add(new Node(curIndex, root, rightMinAndMax[0]));
    		}
    		minAndMax[1] = rightMinAndMax[1];
    	}
    }
}



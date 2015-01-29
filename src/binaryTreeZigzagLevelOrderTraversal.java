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
		TreeNode node;
		int level;
		Node(TreeNode n){node = n;}
	}
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null)
        	return result;
        
        LinkedList<Node> bfsQueue = new LinkedList<Node>();
        Node head = new Node(root);
        head.level = 1;
        bfsQueue.add(head);
        int curLevel = 1;
        boolean isTakenFromHead = true;
        LinkedList<Integer> row = new LinkedList<Integer>();
        while (!bfsQueue.isEmpty()) {
        	if (isTakenFromHead && curLevel != bfsQueue.peek().level) {
        		isTakenFromHead = false;
        		curLevel++;
        		result.add(row);
        		row = new LinkedList<Integer>();
        	} else if (!isTakenFromHead && curLevel != bfsQueue.peekLast().level) {
        		isTakenFromHead = true;
        		curLevel++;
        		result.add(row);
        		row = new LinkedList<Integer>();
        	}
        	if (isTakenFromHead) {
        		Node tmp = bfsQueue.pollFirst();
        		row.add(tmp.node.val);
        		if (tmp.node.left != null) {
        			Node next = new Node(tmp.node.left);
        			next.level = tmp.level + 1;
        			bfsQueue.add(next);
        		}
        		if (tmp.node.right != null) {
        			Node next = new Node(tmp.node.right);
        			next.level = tmp.level + 1;
        			bfsQueue.add(next);
        		}
        	} else {
        		Node tmp = bfsQueue.pollLast();
        		row.add(tmp.node.val);
        		if (tmp.node.right != null) {
        			Node next = new Node(tmp.node.right);
        			next.level = tmp.level + 1;
        			bfsQueue.addFirst(next);
        		}
        		if (tmp.node.left != null) {
        			Node next = new Node(tmp.node.left);
        			next.level = tmp.level + 1;
        			bfsQueue.addFirst(next);
        		}
        	}
        }
        if (row.size() > 0)
        	result.add(row);
        return result;
    }
}



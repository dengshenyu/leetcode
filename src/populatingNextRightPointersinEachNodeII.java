package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;


class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

public class Solution {
	class Node {
		TreeLinkNode node;
		int level;
		Node(TreeLinkNode n) {node = n;}
	}
    public void connect(TreeLinkNode root) {
    	if (root == null)
    		return;
        LinkedList<Node> bfsQueue = new LinkedList<Node>();
        Node head = new Node(root);
        head.level = 1;
        bfsQueue.add(head);
        while (!bfsQueue.isEmpty()) {
        	Node cur = bfsQueue.poll();
        	if (!bfsQueue.isEmpty() && bfsQueue.peek().level == cur.level)
        		cur.node.next = bfsQueue.peek().node;
        	if (cur.node.left != null) {
        		Node left = new Node(cur.node.left);
        		left.level = cur.level + 1;
        		bfsQueue.add(left);
        	}
        	if (cur.node.right != null) {
        		Node right = new Node(cur.node.right);
        		right.level = cur.level + 1;
        		bfsQueue.add(right);
        	}
        }
    }
}

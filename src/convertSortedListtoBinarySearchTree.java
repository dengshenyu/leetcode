package leetcode;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    public TreeNode sortedListToBST(ListNode head) {
    	if (head == null)
    		return null;
        LinkedList<ListNode> list = new LinkedList<ListNode>();
        ListNode it = head;
        while (it != null) {
        	list.add(it);
        	it = it.next;
        }
    	ListNode[] arr = new ListNode[list.size()];
    	int i = 0;
    	for (ListNode node : list) {
    		arr[i++] = node;
    	}
        return sortedArrayToBST(arr, 0, arr.length - 1);
    }
    private TreeNode sortedArrayToBST(ListNode[] arr, int begin, int end) {
    	if (begin == end)
    		return new TreeNode(arr[begin].val);
    	else if (begin > end)
    		return null;
    	else {
    		int middle = (begin + end) / 2;
    		TreeNode root = new TreeNode(arr[middle].val);
    		TreeNode left = sortedArrayToBST(arr, begin, middle - 1);
    		TreeNode right = sortedArrayToBST(arr, middle + 1, end);
    		root.left = left;
    		root.right = right;
    		return root;
    	}
    }
}



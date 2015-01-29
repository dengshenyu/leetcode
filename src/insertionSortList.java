package leetcode;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
        	return head;
        ListNode cur = head.next;
        head.next = null;
        ListNode it, parent, next;
        while (cur != null) {
        	next = cur.next;
        	cur.next = null;
        	it = head;
        	parent = null;
        	while (it != null && it.val < cur.val) {
        		parent = it;
        		it = it.next;
        	}
        	if (it == null)
        		parent.next = cur;
        	else if (parent == null) {
        		cur.next = head;
        		head = cur;
        	} else {
        		cur.next = parent.next;
        		parent.next = cur;
        	}
        	cur = next;
        }
        return head;
    }
}

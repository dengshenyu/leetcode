import java.util.*;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;
        ListNode odd = head, oddTail = head;
        ListNode evenHead = null, evenTail = null;
        while (odd != null && odd.next != null) {
            if (evenTail == null) {
                evenHead = evenTail = odd.next;
            } else {
                evenTail.next = odd.next;
                evenTail = evenTail.next;
            }
            odd.next = odd.next.next;
            odd = odd.next;
            if (odd != null)
                oddTail = odd;
        }
        evenTail.next = null;
        oddTail.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
    }
}
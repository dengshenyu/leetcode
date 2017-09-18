import java.net.Socket;
import java.util.*;

/**
 * Created by shenyuan on 17/2/22.
 */
public class Solution {

    class PeekingIterator implements Iterator<Integer> {
        class Node {
            Integer val;
            Node next;
            Node(Integer val, Node next) {
                this.val = val;
                this.next = next;
            }
        }
        private Node head = null, tail = null;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            while (iterator.hasNext()) {
                Integer val = iterator.next();
                Node node = new Node(val, null);
                if (head == null) {
                    head = tail = node;
                } else {
                    tail.next = node;
                    tail = node;
                }
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (head != null)
                return head.val;
            else
                return null;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Node node = head;
            head = head.next;
            return node.val;
        }

        @Override
        public boolean hasNext() {
            return head != null;
        }
    }
}
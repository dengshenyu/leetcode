import java.util.*;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {

    public class Node {
        int k, v;
        public Node(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i : nums) {
            Integer n = counter.get(i);
            if (n == null)
                n = 1;
            else
                n++;
            counter.put(i, n);
        }
        PriorityQueue<Node> queue = new PriorityQueue<>(k, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.v - o2.v;
            }
        });
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            queue.add(node);
            if (queue.size() > k)
                queue.poll();
        }
        List<Integer> res = new LinkedList<>();
        for (Node node : queue) {
            res.add(node.k);
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = new Solution().topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        for (Integer i : res) {
            System.out.print(i + " ");
        }
    }
}
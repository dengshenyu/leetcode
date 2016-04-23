import java.util.HashMap;
import java.util.Map;

/**
 * Created by shenyuan on 16/3/12.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    private Map<TreeNode, Integer> resultMap = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        if (resultMap.containsKey(root))
            return resultMap.get(root);
        int maxLeftChild = 0;
        int maxRightChild = 0;
        if (root.left != null)
            maxLeftChild = rob(root.left.left) + rob(root.left.right);
        if (root.right != null)
            maxRightChild = rob(root.right.left) + rob(root.right.right);
        int robCurNode = root.val + maxLeftChild + maxRightChild;
        int noRobCurNode = rob(root.left) + rob(root.right);
        int max = robCurNode > noRobCurNode ? robCurNode : noRobCurNode;
        resultMap.put(root, max);
        return max;
    }
}
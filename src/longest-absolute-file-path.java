import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by shenyuan on 17/2/22.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthLongestPathBest("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }

    public int lengthLongestPathBest(String input) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        String[] arr = input.split("\n");
        int result = 0;
        for (String s : arr) {
            int index = s.lastIndexOf("\t");
            int len = index >= 0 ? s.substring(index + 1).length() : s.length();
            int level = index + 3;
            while (level <= stack.size())
                stack.pop();
            if (s.contains(".") && len + stack.peek() > result)
                result = len + stack.peek();
            stack.push(len + stack.peek() + 1);
        }

        return result;
    }


    /*
     * My answer
     */
    class Node {
        int level, len;
        Node(int level, int len) {
            this.level = level;
            this.len = len;
        }
    }


    public int lengthLongestPath(String input) {
        if (input == null)
            return 0;
        int totalLen = input.length();
        Stack<Node> stack = new Stack<Node>();
        int len = 0;
        int i = 0;
        int level = 0;
        boolean isFile = false;
        while (i < totalLen && input.charAt(i) != '\n') {
            if (input.charAt(i) == '.')
                isFile = true;
            len++;
            i++;

        }
        if (isFile)
            return len;
        stack.push(new Node(0, len+1));

        int result = 0;
        while (i < totalLen) {
            len = 0;
            level = 0;
            isFile = false;
            while (i < totalLen && (input.charAt(i) == '\n' || input.charAt(i) == '\t')) {
                if (input.charAt(i) == '\t')
                    level++;
                i += 1;
            }
            //level--;
            while (i < totalLen && input.charAt(i) != '\n') {
                if (input.charAt(i) == '.')
                    isFile = true;
                len++;
                i++;

            }
            while (!stack.isEmpty() && stack.peek().level >= level)
                stack.pop();
            if (isFile) {
                if (stack.isEmpty() && len > result)
                    result  = len;
                else if (!stack.isEmpty() &&  len + stack.peek().len > result)
                    result = len + stack.peek().len;
            } else {

                Node n = stack.isEmpty() ? new Node(level, len + 1) : new Node(level, len + 1 + stack.peek().len);
                stack.push(n);
            }
        }

        return result;
    }
}
package leetcode;

import java.util.LinkedList;

public class Solution {
    public int evalRPN(String[] tokens) {
    	LinkedList<Integer> operands = new LinkedList<Integer>();
        for (int i  = 0; i < tokens.length; i++) {
        	if ( tokens[i].equals("+") || tokens[i].equals("-") || 
        			tokens[i].equals("*")|| tokens[i].equals("/")) {
        		int a = operands.pollLast();
        		int b = operands.pollLast();
        		if ( tokens[i].equals("+"))
        			operands.add(b + a);
        		else if ( tokens[i].equals("-"))
        			operands.add(b - a);
        		else if ( tokens[i].equals("*"))
        			operands.add(b * a);
        		else if ( tokens[i].equals("/"))
        			operands.add(b / a);
        	} else
        		operands.add(Integer.parseInt(tokens[i]));
        }
        return operands.pollLast();
    }
}

package leetcode;

public class Solution {
    public String reverseWords(String s) {
    	StringBuilder result = new StringBuilder();
    	int end = -1, begin = -1;
    	int mIndex = s.length() - 1;
    	boolean first = true;
    	for (int i = mIndex; i >= 0; i--) {
    		if ( s.charAt(i) != ' ' ) {
    			if ( (i + 1 <= mIndex && s.charAt(i+1) == ' ') || ( i + 1  > mIndex) ) {
    				if ( !first )
    					result.append(' ');
    				else
    					first = false;
    				end = i;
    			}
    		} else {
    			if ( end != -1 ) {
    				result.append(s.substring(i+1, end+1));
    				end = -1;
    			}
    		}
    	}
    	if ( end != -1 ) {
    		result.append(s.substring(0, end+1));
    	}
    	return result.toString();
    }
}

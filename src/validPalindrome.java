package test.test;

public class Solution {
    public boolean isPalindrome(String s) {
    	int x = 0, y = s.length() - 1;
    	while (x < y) {
    		while(x < y && !isAlphanumic(s.charAt(x)))
    			x++;
    		while(x < y && !isAlphanumic(s.charAt(y)))
    			y--;
    		if (x < y && !isEquals(s.charAt(x), s.charAt(y)))
    			return false;
    		x++;
    		y--;
    	}
    	return true;
    }
    
    private boolean isEquals(char a, char b) {
    	if (a == b)
    		return true;
    	else
    		return (a > b) ? (32 == a - b) : ( 32 == b - a);
    }
    
    private boolean isAlphanumic(char c) {
    	if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))
    		return true;
    	else
    		return false;
    }

}

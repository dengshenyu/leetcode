package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;



public class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<String>();
        char[] str = new char[digits.length()];
        letterCombinations(digits, str, 0, result);
        return result;
    }
    private void letterCombinations(String digits, char[] str, int pos, LinkedList<String> result) {
    	if (pos == digits.length()) {
    		result.add(new String(str));
    		return;
    	}
    	switch (digits.charAt(pos)) {
    	case '0':
    		str[pos] = '_';
    		letterCombinations(digits, str, pos+1, result);
    		break;
    	case '1':
    		str[pos] = '.';
    		letterCombinations(digits, str, pos+1, result);
    		break;
    	case '2':
    		str[pos] = 'a';
    		letterCombinations(digits, str, pos+1, result);
    		str[pos] = 'b';
    		letterCombinations(digits, str, pos+1, result);
    		str[pos] = 'c';
    		letterCombinations(digits, str, pos+1, result);
    		break;
    	case '3':
    		str[pos] = 'd';
    		letterCombinations(digits, str, pos+1, result);
    		str[pos] = 'e';
    		letterCombinations(digits, str, pos+1, result);
    		str[pos] = 'f';
    		letterCombinations(digits, str, pos+1, result);
    		break;
    	case '4':
    		str[pos] = 'g';
    		letterCombinations(digits, str, pos+1, result);
    		str[pos] = 'h';
    		letterCombinations(digits, str, pos+1, result);
    		str[pos] = 'i';
    		letterCombinations(digits, str, pos+1, result);
    		break;
    	case '5':
    		str[pos] = 'j';
    		letterCombinations(digits, str, pos+1, result);
    		str[pos] = 'k';
    		letterCombinations(digits, str, pos+1, result);
    		str[pos] = 'l';
    		letterCombinations(digits, str, pos+1, result);
    		break;
    	case '6':
    		str[pos] = 'm';
    		letterCombinations(digits, str, pos+1, result);
    		str[pos] = 'n';
    		letterCombinations(digits, str, pos+1, result);
    		str[pos] = 'o';
    		letterCombinations(digits, str, pos+1, result);
    		break;
    	case '7':
    		str[pos] = 'p';
    		letterCombinations(digits, str, pos+1, result);
    		str[pos] = 'q';
    		letterCombinations(digits, str, pos+1, result);
    		str[pos] = 'r';
    		letterCombinations(digits, str, pos+1, result);
    		str[pos] = 's';
    		letterCombinations(digits, str, pos+1, result);
    		break;
    	case '8':
    		str[pos] = 't';
    		letterCombinations(digits, str, pos+1, result);
    		str[pos] = 'u';
    		letterCombinations(digits, str, pos+1, result);
    		str[pos] = 'v';
    		letterCombinations(digits, str, pos+1, result);
    		break;
    	case '9':
    		str[pos] = 'w';
    		letterCombinations(digits, str, pos+1, result);
    		str[pos] = 'x';
    		letterCombinations(digits, str, pos+1, result);
    		str[pos] = 'y';
    		letterCombinations(digits, str, pos+1, result);
    		str[pos] = 'z';
    		letterCombinations(digits, str, pos+1, result);
    		break;
    	}
    }
}

package test.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	public String strStr(String haystack, String needle) {
		if (haystack == null || needle == null)
			return null;
		if (needle.isEmpty())
			return haystack;
		int i,j;
		for (i = 0; i <= haystack.length() - needle.length(); i++) {
			for (j = 0; j < needle.length(); j++) {
				if (haystack.charAt(i + j) != needle.charAt(j))
					break;
			}
			if (j == needle.length())
				return haystack.substring(i);
		}
		return null;
	}
}

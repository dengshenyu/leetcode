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
    public String simplifyPath(String path) {
        LinkedList<String> pl = new LinkedList<String>();
        boolean root = true;
        for (int i = 0; i < path.length(); ) {
        	if (root) {
        		while (i < path.length() && path.charAt(i) == '/')
        			i++;
        		//pl.add("/");
        		root = false;
        	} else {
        		StringBuilder sb = new StringBuilder();
        		while (i < path.length() && path.charAt(i) != '/') {
        			sb.append(path.charAt(i));
        			i++;
        		}
        		while (i < path.length() && path.charAt(i) == '/')
        			i++;
        		String file = sb.toString();
        		if (!file.equals(".") && !file.equals(".."))
        			pl.add(file);
        		else if (file.equals("..") && pl.size() > 0)
        			pl.pollLast();
        	}
        }
        StringBuilder sb = new StringBuilder();
        for (String s : pl)
        	sb.append("/" + s);
        String result = sb.toString();
        if (result.isEmpty())
        	return "/";
        else
        	return result;
    }
}

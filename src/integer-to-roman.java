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
    public String intToRoman(int num) {
        LinkedList<String> list = new LinkedList<String>();
        int priority = 1;
        while (num > 0) {
        	int d = num % 10;
        	if (d != 0) {
        		switch (d * priority) {
        		case 1:
        			list.add("I");
        			break;
        		case 2:
        			list.add("II");
        			break;
        		case 3:
        			list.add("III");
        			break;
        		case 4:
        			list.add("IV");
        			break;
        		case 5:
        			list.add("V");
        			break;
        		case 6:
        			list.add("VI");
        			break;
        		case 7:
        			list.add("VII");
        			break;
        		case 8:
        			list.add("VIII");
        			break;
        		case 9:
        			list.add("IX");
        			break;
        		case 10:
        			list.add("X");
        			break;
        		case 20:
        			list.add("XX");
        			break;
        		case 30:
        			list.add("XXX");
        			break;
        		case 40:
        			list.add("XL");
        			break;
        		case 50:
        			list.add("L");
        			break;
        		case 60:
        			list.add("LX");
        			break;
        		case 70:
        			list.add("LXX");
        			break;
        		case 80:
        			list.add("LXXX");
        			break;
        		case 90:
        			list.add("XC");
        			break;
        		case 100:
        			list.add("C");
        			break;
        		case 200:
        			list.add("CC");
        			break;
        		case 300:
        			list.add("CCC");
        			break;
        		case 400:
        			list.add("CD");
        			break;
        		case 500:
        			list.add("D");
        			break;
        		case 600:
        			list.add("DC");
        			break;
        		case 700:
        			list.add("DCC");
        			break;
        		case 800:
        			list.add("DCCC");
        			break;
        		case 900:
        			list.add("CM");
        			break;
        		case 1000:
        			list.add("M");
        			break;
        		case 2000:
        			list.add("MM");
        			break;
        		case 3000:
        			list.add("MMM");
        			break;
        		}
        	}
        	priority *= 10;
        	num /= 10;
        }
        String result = "";
        while (!list.isEmpty()) {
        	result += list.pollLast();
        }
        return result;
    }
}

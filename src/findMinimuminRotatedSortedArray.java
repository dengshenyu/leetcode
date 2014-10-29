package leetcode;

public class Solution {
    public int findMin(int[] num) {
    	return findMin(num, 0, num.length - 1);
    }
    private int findMin(int[] num, int begin, int end) {
    	if (end == begin)
    		return num[begin];
    	else if (end - begin == 1)
    		return num[end] < num[begin] ? num[end] : num[begin];
    	int middle = (begin + end) / 2;
    	if (num[middle] > num[begin] && num[middle] > num[end]) {
    		return findMin(num, middle, end);
    	} else {
    		return findMin(num, begin, middle);
    	}
    }
}

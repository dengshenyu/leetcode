package test.test;

public class Solution {
    public int maxProduct(int[] A) {
        int[] min = new int[A.length];
        int[] max = new int[A.length];
        int result = Integer.MIN_VALUE;
        for ( int i = 0; i < A.length; i++ ) {
        	min[i] = A[i];
        	max[i] = A[i];
        	if ( i > 0 ) {
        		int tmp = min[i-1] * A[i];
        		if (tmp < min[i])
        			min[i] = tmp;
        		if (tmp > max[i])
        			max[i] = tmp;
        		
        		tmp = max[i-1] * A[i];
        		if (tmp < min[i])
        			min[i] = tmp;
        		if (tmp > max[i])
        			max[i] = tmp;
        	}
        	if (max[i] > result)
        		result = max[i];
        }
        return result;
    }
}
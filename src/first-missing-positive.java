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
	public int firstMissingPositive(int[] A) {
		for (int i = 0; i < A.length; ) {
			if (A[i] > 0 && A[i] != i+1 && A[i] <= A.length && A[i] != A[A[i]-1]) {
				swap(A, i, A[i] - 1);
			} else
				i++;
		}
		for (int i = 0; i < A.length; i++) {
			if (A[i] != i + 1)
				return i + 1;
		}
		return A.length + 1;
	}
	private void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
}

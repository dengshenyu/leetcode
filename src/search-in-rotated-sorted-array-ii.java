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
    public boolean search(int[] A, int target) {
  	if (A.length == 0 )
  		return false;
  	if (A[0] > A[A.length - 1]) {
          int pivot = findPivot(A, 0, A.length - 1, A.length - 1);
          int pos = searchSorted(A, 0, pivot, target);
          if (pos != -1)
          	return true;
          pos = searchSorted(A, pivot+1, A.length-1, target);
          if (pos != -1)
          	return true;
          return false;
  	} else if (A.length > 1 && A[0] == A[A.length - 1]) {
  		for (int i = 0; i < A.length; i++) {
  			if (A[i] == target)
  				return true;
  		}
  		return false;
  	} else {
  		return searchSorted(A, 0, A.length - 1, target) != -1;
  	}

  }
  
  private int searchSorted(int[] A, int left, int right, int target) {
  	if (left == right) {
  		if (A[left] == target)
  			return left;
  		else 
  			return -1;
  	} else if (left > right)
  		return -1;
  	int middle = (left + right) / 2;
  	if (A[middle] == target)
  		return middle;
  	else if (A[middle] < target) {
  		return searchSorted(A, middle+1, right, target);
  	} else {
  		return searchSorted(A, left, middle - 1, target);
  	}
  }
  
  private int findPivot(int[] A, int left, int right, int rightMost) {
  	//System.out.println(left + " " + right);
  	if (left == right)
  		return left;
  	int middle = (left + right) / 2;
  	//System.out.println(middle);
  	if (A[middle] > A[middle+1])
  		return middle;
  	if ( A[middle] > A[rightMost])
  		return findPivot(A, middle+1, right, rightMost);
  	else
  		return findPivot(A, left, middle - 1, rightMost);
  }
}

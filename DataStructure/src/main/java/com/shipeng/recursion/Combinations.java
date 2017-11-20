package com.shipeng.recursion;

import java.util.List;
import java.util.ArrayList;

public class Combinations {

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (n <= 0 || n < k) {
        	    return result;
        }
		
		List<Integer> path = new ArrayList<Integer>();
		helper(result, path, 1, k, n);
		return result;
	}

	// Method 1: "add" or "don't add"
	private void helper(List<List<Integer>> result, List<Integer> path, int index, int k, int n) {
		if (index > n + 1) {
			return;
		}
		if (path.size() == k) {
			result.add(new ArrayList<Integer>(path));
			return;
		}

		// add current index
		path.add(index);
		helper(result, path, index + 1, k, n);
		path.remove(path.size() - 1);

		// don't add
		helper(result, path, index + 1, k, n);
	}
	
	// Method 2: // DFS
	private static void helperII(List<List<Integer>> result, List<Integer> path, int index, int k, int n) {
        if (path.size() == k) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = index; i <= n; i++) {
            path.add(i);
            helperII(result,path, i+1, k, n);
            path.remove(path.size()-1);
        }
    }

	public static void main(String[] args) {
		Combinations c = new Combinations();
		List<List<Integer>> result = c.combine(4, 2);
		System.out.println(result);
	}

}

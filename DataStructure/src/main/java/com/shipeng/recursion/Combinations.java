package com.shipeng.recursion;

import java.util.List;
import java.util.ArrayList;

public class Combinations {

	public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n <= 0 || n < k) {
        	return result;
        }
        
        List<Integer> path = new ArrayList<Integer>();
        helper(result, path, 1, k, n);
        return result;
    }
    
    private static void helper(List<List<Integer>> result, List<Integer> path, int index, int k, int n) {
        if (path.size() == k) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = index; i <= n; i++) {
            path.add(i);
            helper(result,path, i+1, k, n);
            path.remove(path.size()-1);
        }
    }
    
    public static void main(String[] args) {
    	List<List<Integer>> result = combine(4,2);
    	System.out.println(result);
    }
	
}

package com.shipeng.tree;

/*
 * Convert sorted array to binary search tree.
 * 
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * 
 */


public class ConvertSortedArrayToBinarySearchTree {

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		
		return sortedArrayToBST(nums, 0, nums.length - 1);
	}
	
	private TreeNode sortedArrayToBST(int[] num, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) /2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = sortedArrayToBST(num, start, mid -1);
		root.right = sortedArrayToBST(num, mid+1, end);
		
		return root;
	}
	
	
}

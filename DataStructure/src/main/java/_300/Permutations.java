package _300;

import java.util.ArrayList;
import java.util.List;

/*
 * Permutations
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * input : [1,2,3]
 * output:
 * [
 *     [1,2,3],
 *     [1,3,2],
 *     [2,1,3],
 *     [2,3,1],
 *     [3,1,2],
 *     [3,2,1]
 * ]
 */

public class Permutations {

	public List<List<Integer>> permute(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		List<List<Integer>> result = new ArrayList<>();
		helper(result, nums, 0);
		return result;
	}

	private void helper(List<List<Integer>> result, int[] nums, int index) {
		if (index == nums.length) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			for (int i : nums) {
				tmp.add(i);
			}
			result.add(tmp);
			return;
		}
		for (int i = index; i < nums.length; i++) {
			swap(nums, i, index);
			helper(result, nums, index + 1);
			swap(nums, i, index);
		}
	}

	private void swap(int[] nums, int left, int right) {
		int tmp = nums[left];
		nums[left] = nums[right];
		nums[right] = tmp;
	}

}

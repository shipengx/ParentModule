package aa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static List<List<Integer>> threeSum(int[] nums) {
		if (nums == null || nums.length < 3) {
			return null;
		}
		Arrays.sort(nums);

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || nums[i] > nums[i - 1]) {
				int j = i + 1;
				int k = nums.length - 1;
				while (j < k) {
					int sum = nums[i] + nums[j] + nums[k];
					if (sum == 0) {
						List<Integer> tmpList = new ArrayList<Integer>();
						tmpList.add(nums[i]);
						tmpList.add(nums[j]);
						tmpList.add(nums[k]);
						result.add(tmpList);

						j++;
						k--;
						
						// handle duplicate here
						while (j < k && nums[j] == nums[j-1]) {
							j++;
						}
						while (j < k && nums[k] == nums[k+1]) {
							k--;
						}
						
					} else if (sum < 0) {
						j++;
					} else if (sum > 0) {
						k--;
					}
				}
			}
		}

		return result;

	}

	public static void main(String[] args) {
		int[] input = new int[] { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> result = threeSum(input);
		System.out.println(result);

	}
}

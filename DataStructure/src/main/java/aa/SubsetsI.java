package aa;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a set of characters represented by a String, return a list containing all subsets of the characters.
 * Assumptions
 * 
 * There are no duplicate characters in the original set.
​ * Examples
 *
 * Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
 * Set = "", all the subsets are [""]
 * Set = null, all the subsets are []
 * 
 */

public class SubsetsI {

	public List<String> subSets(String set) {
		// Write your solution here.

		List<String> result = new ArrayList<String>();
		if (set == null) {
			return result;
		}
		char[] arraySet = set.toCharArray();
		// record the current subset
		StringBuilder sb = new StringBuilder();
		helper(arraySet, sb, 0, result);
		return result;
	}

	// at each level, determine the character at the position "index" to be
	// picked or not.
	private void helper(char[] set, StringBuilder sb, int index, List<String> result) {
		// terminate condition:
		// when we finishes determining for all the characters pick or not,
		// we have a complete subset.
		if (index == set.length) {
			result.add(sb.toString());
			return;
		}
		// 1. not pick the character at index.
		helper(set, sb, index + 1, result);
		// 2. pick the character at index
		sb.append(set[index]);
		helper(set, sb, index + 1, result);
		// remember to remove the added character when back tracking to the
		// previous level.
		sb.deleteCharAt(sb.length() - 1);
	}
	
	public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        helper(result, path, nums, 0);
        return result;
    }
    
    private static void helper(List<List<Integer>> result, List<Integer> path, int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.addAll(path);
            result.add(tmp);
            return;
        }
        //do not add current index integer to the path
        helper(result, path, nums, index+1);
        //add current index integer to the path
        path.add(nums[index]);
        helper(result, path, nums, index+1);
        path.remove(path.size()-1);
    }
    
    public static void main(String[] args) {
    	int[] input_array = new int[] { 1,2,3};
    	List<List<Integer>> result = subsets(input_array);
    	System.out.println(result);
    }
}

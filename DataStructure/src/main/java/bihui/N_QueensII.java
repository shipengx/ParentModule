package bihui;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * N-Queens II
 * 
 * Follow up for N-Queens problem. Now, instead of outputting board
 * configurations, return the total number of distinct solutions.
 *
 */

public class N_QueensII {

	public int totalNQueens(int n) {
		Set<List<Integer>> result = new HashSet<>();
		List<Integer> curSolution = new ArrayList<>();
		helper(result, curSolution, n);
		return result.size();
	}

	private void helper(Set<List<Integer>> result, List<Integer> curSolution, int n) {
		if (curSolution.size() == n) {
			result.add(new ArrayList<>(curSolution));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (isValid(curSolution, i)) {
				curSolution.add(i);
				helper(result, curSolution, n);
				curSolution.remove(curSolution.size() - 1);
			}
		}
	}

	// check if current col is valid
	private boolean isValid(List<Integer> curSolution, int col) {
		// check column
		for (int i = 0; i < curSolution.size(); i++) {
			if (curSolution.get(i) == col) {
				return false;
			}
			int rowDistance = Math.abs(curSolution.size() - i);
			int colDistance = Math.abs(col - curSolution.get(i));
			if (rowDistance == colDistance) {
				return false;
			}
		}
		return true;
	}

}

package bihui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_QueensI {

	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		List<String> path = new ArrayList<>(n);
		if (n < 1) {
			return result;
		}
		dfs(n, path, result);
		return result;
	}

	private static void dfs(int n, List<String> path, List<List<String>> result) {
		if (path.size() == n) {
			result.add(new ArrayList<String>(path));
			return;
		}

		for (int col = 0; col < n; col++) {
			if (!isValid(col, path)) {
				continue;
			}

			char[] chars = new char[n];
			Arrays.fill(chars, '.');
			chars[col] = 'Q';

			path.add(new String(chars));
			dfs(n, path, result);
			path.remove(path.size() - 1);
		}
	}

	// check if current col has conflict with previous Q column
	private static boolean isValid(int col, List<String> path) {
		int curRow = path.size();
		// check column
		for (int i = 0; i < curRow; i++) {
			int qCol = path.get(i).indexOf("Q");

			if (qCol == col) {
				return false;
			}

			int rowDistance = Math.abs(curRow - i);
			int colDistance = Math.abs(col - qCol);

			if (rowDistance == colDistance) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		List<List<String>> result = solveNQueens(4);
		System.out.println(result);
	}

}

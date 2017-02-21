package aa;

import java.util.ArrayList;
import java.util.List;

/*
 * Pascal's Triangle II
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3,
 * return [1,3,3,1].
 * 
 * Note: 
 * Could you optimize your algorithm to use only O(k) extra space ?
 * 
 * 1000 k = 0
 * 1100 k = 1
 * 1110 
 * 1210 k = 2
 * 1211
 * 1231
 * 1331 k = 3
 * 
 * 
 */

public class PascalTriangleII {

	public List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<Integer>();

		if (rowIndex < 0) {
			return result;
		}

		result.add(1);
		for (int i = 1; i <= rowIndex; i++) {
			for (int j = result.size() - 2; j >= 0; j--) {
				result.set(j + 1, result.get(j) + result.get(j + 1));
			}
			result.add(1);
		}
		return result;
	}

	/* i <===> row
	 * j <===> column
	 * 
	 * idea is to get current level from previous level.
	 * calculate each position from right to left, to get the current level.
	 * 
	 */
	
	public List<Integer> getRowI(int rowIndex) {
		ArrayList<Integer> result = new ArrayList<Integer>(rowIndex + 1);
		for (int i = 0; i <= rowIndex; i++) {
			result.add(0);
		}
		result.set(0, 1);
		for (int i = 1; i <= rowIndex; i++) {
			result.set(i, 1);
			for (int j = i - 1; j > 0; j--) {
				result.set(j, result.get(j) + result.get(j - 1));
				//set current j column with what we have from previous level j column and j-1 column
			}
		}
		return result;
	}

}

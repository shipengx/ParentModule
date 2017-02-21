package aa;

import java.util.ArrayList;
import java.util.List;

/*
 * Pascal Triangle
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5,
 * 
 * return 
 * 
 * [
 *        [1],
 *       [1,1],
 *      [1,2,1],
 *     [1,3,3,1],
 *    [1,4,6,4,1]
 * ]
 * 
 */

public class PascalTriangleI {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (numRows <= 0) {
			return result;
		}

		List<Integer> prev = new ArrayList<Integer>();
		prev.add(1);
		result.add(prev);

		for (int i = 2; i <= numRows; i++) {
			List<Integer> cur = new ArrayList<Integer>();

			cur.add(1); // first
			for (int j = 0; j < prev.size() - 1; j++) {
				cur.add(prev.get(j) + prev.get(j + 1)); // middle
			}
			cur.add(1); // last

			result.add(cur);
			prev = cur;
		}

		return result;
	}

}

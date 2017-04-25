package bihui;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Largest Rectangle in Histogram Given n non-negative integers representing the
 * histogram's bar height where the width of each bar is 1, find the area of
 * largest rectangle in the histogram.
 * 
 *
 */

public class LargestRectangleInHistogram {

	public int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0) {
			return 0;
		}
		// all the values in the array are non-negative.
		int result = 0;
		// note that the stack contains the "index".
		// not the "value" of the heights.
		Deque<Integer> stack = new LinkedList<Integer>();
		for (int i = 0; i <= heights.length; i++) {
			// we need a way of popping out all the elements in the stack
			// at last, so that we explicitly add a bar of height 0.
			int cur = i == heights.length ? 0 : heights[i];
			while (!stack.isEmpty() && heights[stack.peekFirst()] >= cur) {
				int height = heights[stack.pollFirst()];
				// determine the left boundary of the largest rectangle with
				// height height[i].
				int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
				// determine the right boundary of the largest rectangle
				// with height of the popped element.
				result = Math.max(result, height * (i - left));
			}
			stack.offerFirst(i);
		}
		return result;
	}

}

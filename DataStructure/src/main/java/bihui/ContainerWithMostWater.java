package bihui;

/*
 * Container with most water
 * 
 * Given n non-negative integers a1, a2, ...., an, where each represents a point
 * at coordinate (i, ai). 
 * N vertical lines are drawn such that the two endpoints of line i is at (i,ai)
 * and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container
 * the most water.
 * 
 * Note: you may not slant the container and n is at least 2.
 * 
 * Summary
 * we have to maximize the area that can be formed between the vertical lines using the shorter
 * line as length and the distance between the lines as the width of the rectangle forming the area.
 * 
 */

public class ContainerWithMostWater {

	public int maxArea(int[] height) {
		int maxArea = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
			}
		}
		return maxArea;
	}

	/**
	 * Approach #2. Algorithm The intuition behind this approach is that the
	 * area formed between the lines will always be limited by the height of the
	 * shorter line. Further, the father the line, the more will be the area
	 * obtained.
	 * 
	 * We take two pointers, one at the beginning and one at the end of the
	 * array constituting the length of the lines. Further, we maintain a
	 * variable maxarea to store the maximum area obtained till now. At every
	 * step, we find out the area formed between them, update maxArea and move
	 * the pointer pointing to the shorter line towards the other end by one
	 * step.
	 * 
	 * the algorithm can be better understood by looking at the example below.
	 * 
	 * 1 8 6 2 5 4 8 3 7
	 * 
	 * How this approach works ? Initially we consider the area constituting the
	 * exterior most lines. Now, to maximize the area, we need to consider the
	 * area between the lines of larger lengths, if we try to move the pointer
	 * at the longer line inwards, we won't gain any increase in area, since it
	 * is limited by the shorter line. But moving the shorter line's pointer
	 * could turn out to be beneficial, as per the same argument, despite the
	 * reduction in the width. this is done since a relatively longer line
	 * obtained by moving the shorter line's pointer might overcome the
	 * reduction in area caused by width reduction.
	 * 
	 * Time complexity: O(n) single pass.
	 * Space complexity: O(1). Constant space is used.
	 * 
	 */

	public int maxAreaII(int[] height) {
		int maxArea = 0, l = 0, r = height.length - 1;
		while (l < r) {
			maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
			if (height[l] < height[r]) {
				l++;
			} else {
				r--;
			}
		}
		return maxArea;
	}

}

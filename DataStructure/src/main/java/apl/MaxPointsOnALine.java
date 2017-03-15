package apl;

import java.awt.Point;
import java.util.HashMap;

/*
 * Most points on a line
 * Given an array of 2D coordinates of points (all the coordinates are integers), 
 * find the largest number of points that can be crossed by a single line in 2D space.
 * 
 * Assumptions:
 *     the given array is not null and it has at least 2 points
 * Examples:
 *     <0,0>, <1,1>, <2,3>, <3,3>, the maximum number of points on a line is 3
 *     (<0,0>, <1,1>, <3,3> are on the same line).
 *     
 * 
 */

public class MaxPointsOnALine {
	
	public int most(Point[] points) {
		// Assumptions : points is not null, and points.length >= 2.
		// record the maximum number of points on the same line.
		int result = 0;
		// we use each pair of points to form a line
		for (int i = 0; i < points.length; i++) {
			// any line can be represented by a point and a slope.
			// we take the point as seed and try to find all possible slopes.
			Point seed = points[i];
			// record the points with same <x,y>
			int same = 1;
			// record the points with same x, for the special case of infinite slope.
			int sameX = 0;
			// record the maximum number of points on the same line crossing the seed point.
			int most = 0;
			// a map with all possible slopes.
			HashMap<Double, Integer> cnt = new HashMap<Double, Integer>();
			for (int j = 0; j < points.length; j++) {
				if (i == j) {
					continue;
				}
				Point tmp = points[j];
				if (tmp.x == seed.x && tmp.y == seed.y) {
					// handle the points with same <x,y>
					same++;
				}else if (tmp.x == seed.x) {
					sameX++;
				}else {
					// otherwise, just calcuate the slope and increment the counter for the calcuated slope.
					double slope = ((tmp.y - seed.y) + 0.0) / (tmp.x - seed.x);
					if (!cnt.containsKey(slope)) {
						cnt.put(slope, 1);
					}else {
						cnt.put(slope, cnt.get(slope) + 1);
					}
					most = Math.max(most, cnt.get(slope));
				}
			}
			most = Math.max(most, sameX) + same;
			result = Math.max(result, most);	
		}
		return result;
	}
}

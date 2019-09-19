package sf;

import java.util.*;

/**
 * Merge Intervals
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 * Input : [[1,3]. [2,6], [8,10], [15,18]]
 * Output : [[1,6], [8,10], [15, 18]]
 * Explanation : Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * Example 2:
 * Input : [[1,4], [4,5]]
 * Output: [[1,5]]
 * Explanation : Intervals [1,4] and [4,5] are considered overlapping.
 *
 */



public class MergeIntervals {

    class Interval {
        int start, end;

        public Interval(int a, int b) {
            start = a;
            end = b;
        }
    }

    class StartComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            if (a.start < b.start) {
                return -1;
            } else if (a.start == b.start) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    // method 1
    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0) return new int[0][0];

        List<Interval> list = new ArrayList<>();
        int i;
        for (i = 0; i < intervals.length; i++) {
            list.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        // Sort by start value
        Collections.sort(list, new StartComparator());

        LinkedList<Interval> merged = new LinkedList<>();

        for (Interval intv: list) {
            if (merged.isEmpty() || merged.getLast().end < intv.start) {
                merged.add(intv);
            }
            else {
                merged.getLast().end = Math.max(merged.getLast().end, intv.end);
            }
        }

        Interval[] temp = merged.toArray(new Interval[merged.size()]);
        int[][] res = new int[temp.length][2];
        for (i = 0; i < temp.length; i++) {
            res[i][0] = temp[i].start;
            res[i][1] = temp[i].end;
        }
        return res;
    }

    // method 2:
    public int[][] mergeII(int[][] intervals) {

        if(intervals.length <= 1) {
            return intervals;
        }

        List<int[]> merged = new ArrayList<>();

        //Sort the array based on start times in ascending order
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){
            //If the start time of next is before the end time of current, it's an overlap merge it
            if(intervals[i][0] <= end ){
                end = Math.max(intervals[i][1], end);
            }else{
                int[] list = new int[]{start, end};
                merged.add(list);
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        int[] list = new int[]{start, end};
        merged.add(list);


        return merged.toArray(new int[merged.size()][2]);
    }


}

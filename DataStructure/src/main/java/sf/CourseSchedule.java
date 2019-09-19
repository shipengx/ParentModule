package sf;

import java.util.ArrayList;

/**
 * Course Schedule
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to take course 1,
 * which is expressed as a pair : [0,1]
 *
 * Given the total number of courses and a list of prerequisites pairs, is it possible
 * for you to finish all courses ?
 *
 * Example 1:
 * Input:     2, [[1,0]]
 * Output:    true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 *
 * Example 2:
 * Input:     2, [[1,0], [0,1]]
 * Output:    false
 * Explanation: There are a total of 2 course to take.
 *              To take course 1 you should have finished course 0,
 *              and to take course 0 you should also have finished course 1. so it is impossible.
 *
 * Note:
 *     1. The input prerequisites is a graph represented by a list of edges,
 *     not adjacency matrices. Read more about how a graph is represented.
 *
 *     2. You may assume that there are no duplicate edges in the input prerequisites.
 *
 */

public class CourseSchedule {


    // this problem can be converted to finding if a graph has a cycle.
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];
            graph.get(course).add(prerequisite);
        }

        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!canFinish(i, graph, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean canFinish(int curr, ArrayList<ArrayList<Integer>> graph, int[] visited) {
        if (visited[curr] == 1) {
            return false;
        }
        /*
             if (visited[curr] == 2) {
                return true;
             }
         */
        visited[curr] = 1;
        for (int next : graph.get(curr)) {
            if (!canFinish(next, graph, visited)) {
                return false;
            }
        }
        visited[curr] = 0;
        // or visited[curr] = 2;
        return true;
    }

}

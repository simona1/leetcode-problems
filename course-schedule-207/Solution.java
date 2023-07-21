
/**
 * LeetCode problem # 207, 'Course Schedule'
 * https://leetcode.com/problems/course-schedule/
 */

import java.util.*;

class Course {
    public Integer degrees;
    public List<Integer> connections;

    public Course() {
        this.degrees = 0;
        this.connections = new LinkedList<>();
    }
}

class Solution {
    private Course createIfAbsent(Map<Integer, Course> neigh, Integer course) {
        neigh.computeIfAbsent(course, k -> new Course());
        return neigh.get(course);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }

        Map<Integer, Course> neigh = new HashMap<>();
        for (int[] pre : prerequisites) {
            Course prev = createIfAbsent(neigh, pre[1]);
            Course next = createIfAbsent(neigh, pre[0]);

            prev.connections.add(pre[0]);
            ++next.degrees;
        }

        int total = prerequisites.length;
        LinkedList<Integer> noprereqs = new LinkedList<>();

        for (Map.Entry<Integer, Course> entry : neigh.entrySet()) {
            Course curr = entry.getValue();
            if (curr.degrees == 0) {
                noprereqs.add(entry.getKey());
            }
        }

        int removed = 0;
        while (noprereqs.size() > 0) {
            Integer curr = noprereqs.pop();
            for (Integer next : neigh.get(curr).connections) {
                Course dep = neigh.get(next);
                dep.degrees -= 1;
                ++removed;
                if (dep.degrees == 0) {
                    noprereqs.add(next);
                }
            }
        }
        return removed == total;
    }
}


/**
 * LeetCode problem # 1376, 'Time Needed to Inform All Employees'
 * https://leetcode.com/problems/time-needed-to-inform-all-employees/
 */

import java.util.*;

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // map manager id to list of employee ids
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.computeIfAbsent(manager[i], value -> new LinkedList<Integer>()).add(i);
        }
        return informTime[headID] + numOfMinImpl(headID, map, informTime);
    }

    private int numOfMinImpl(int managerId, Map<Integer, LinkedList<Integer>> map, int[] informTime) {
        // not a manager id
        if (informTime[managerId] == 0) {
            return 0;
        }

        int maxTime = 0;
        // recurse to compute max time required
        for (int id : map.get(managerId)) {
            maxTime = Math.max(maxTime, informTime[id] + numOfMinImpl(id, map, informTime));
        }
        return maxTime;
    }
}
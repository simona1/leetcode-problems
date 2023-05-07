
/**
 * LeetCode problem # 1964, 'Find the Longest Valid Obstacle Course at Each
 * Position'
 * https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position
 */

class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] arr = new int[n];
        int[] res = new int[n];
        int limit = 0;

        for (int i = 0; i < n; ++i) {
            int curr = obstacles[i];
            int index = findInsertPosition(arr, curr, limit);
            if (index == limit) {
                ++limit;
            }
            arr[index] = curr;
            res[i] = index + 1;
        }
        return res;
    }

    private int findInsertPosition(int[] arr, int num, int lim) {
        int lo = -1;
        int hi = lim;

        while (lo + 1 != hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] <= num) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return hi;
    }
}

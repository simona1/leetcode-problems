/**
 * LeetCode problem # 1266, 'Minimum Time Visiting All Points'
 * https://leetcode.com/problems/minimum-time-visiting-all-points/
 */

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        for (int i = 1; i < points.length; ++i) {
            res += getDistance(points[i - 1], points[i]);
        }
        return res;
    }

    private int getDistance(int[] p1, int[] p2) {
        return Math.max(Math.abs(p1[0] - p2[0]), Math.abs(p1[1] - p2[1]));
    }
}

/*
 * In two-dimensional space, the Chebyshev distance between two points (x1, y1)
 * and (x2, y2) is defined as the maximum difference between their coordinates
 * along any axis. Mathematically, it can be expressed as:
 * 
 * D = max(|x2 - x1|, |y2 - y1|)
 */
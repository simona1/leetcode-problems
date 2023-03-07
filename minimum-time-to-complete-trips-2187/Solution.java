/*
 * LeetCode problem # 2187, 'Minimum Time to Complete Trips'
 * https://leetcode.com/problems/minimum-time-to-complete-trips
 */

class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int maxTime = 0;
        for (int t : time) {
            maxTime = Math.max(maxTime, t);
        }

        long lo = 1;
        long hi = (long) maxTime * totalTrips;
        while (lo < hi) {
            long mid = (hi + lo) / 2;

            if (isSufficient(time, mid, totalTrips)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public boolean isSufficient(int[] time, long currentTime, int totalTrips) {
        long currentTrips = 0;
        for (int t : time) {
            currentTrips += currentTime / t;
        }

        return currentTrips >= totalTrips;
    }
}

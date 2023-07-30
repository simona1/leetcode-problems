
/**
 * LeetCode problem # 1870, 'Minimum Speed to Arrive on Time'
 * https://leetcode.com/problems/minimum-speed-to-arrive-on-time/
 */

class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int upperLimit = 10000001;
        int n = dist.length;
        int low = 0;
        int high = upperLimit;

        while (low + 1 != high) {
            int mid = (low + high) / 2;

            double sum = 0;
            for (int i = 0; i < n - 1; ++i) {
                sum += Math.ceil(((double) dist[i]) / mid);
            }

            sum = sum + (((double) dist[n - 1]) / mid);

            if (sum > hour) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high == upperLimit ? -1 : high;

    }
}
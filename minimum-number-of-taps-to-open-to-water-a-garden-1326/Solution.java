
/**
 * LeetCode problem # 1326, 'Minimum Number of Taps to Open to Water a Garden'
 * https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
 */

class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] maxRange = new int[n + 1];

        for (int i = 0; i < ranges.length; ++i) {
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);
            maxRange[left] = Math.max(maxRange[left], right);
        }

        int res = 0;
        int curr = 0;
        int next = 0;

        for (int i = 0; i <= n; ++i) {
            if (i > next) {
                return -1;
            }

            if (i > curr) {
                ++res;
                curr = next;
            }
            next = Math.max(next, maxRange[i]);
        }
        return res;

    }
}
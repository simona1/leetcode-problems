
/**
 * LeetCode problem # 1802, 'Maximum Value at a Given Index in a Bounded Array'
 * https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array
 */

class Solution {
    public static int maxValue(int n, int index, int maxSum) {

        long lo = 1;
        long hi = maxSum + 1;

        while (lo + 1 != hi) {
            long mid = lo + ((hi - lo) >> 1);
            long sum = mid * mid;
            long leftSide = index - (mid - 1);
            long rightSide = (n - 1) - (index + (mid - 1));

            sum += (leftSide > 0 ? leftSide : leftSide * (1 - leftSide) / 2);
            sum += (rightSide > 0 ? rightSide : rightSide * (1 - rightSide) / 2);

            if (sum > maxSum) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return (int) lo;
    }
}

/**
 * LeetCode problem # 1064, 'Fixed Point'
 * https://leetcode.com/problems/fixed-point
 */

class Solution {
    public int fixedPoint(int[] arr) {
        int lo = -1;
        int hi = arr.length;

        int res = -1;

        while (lo + 1 != hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] == mid) {
                res = mid;
                hi = mid;
            } else if (arr[mid] < mid) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return res;
    }
}
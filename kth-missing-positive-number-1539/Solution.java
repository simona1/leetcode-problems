
/**
 * LeetCode problem # 1539, 'Kth Missing Positive Number'
 * https://leetcode.com/problems/kth-missing-positive-number/
 */

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = -1;
        int high = arr.length;

        while (low + 1 != high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] - mid - 1 < k) {
                low = mid;
            } else {
                high = mid;
            }

        }
        return high + k;
    }
}

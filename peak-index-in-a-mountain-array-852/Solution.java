
/**
 * LeetCode problem # 852, 'Peak Index in a Mountain Array'
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 */

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int lo = -1;
        int hi = arr.length;

        while (lo + 1 != hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] <= arr[mid + 1]) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return hi;
    }
}
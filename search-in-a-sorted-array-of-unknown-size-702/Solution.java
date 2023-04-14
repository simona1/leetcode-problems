
/**
 * LeetCode problem # 702, 'Search in a Sorted Array of Unknown Size'
 * https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
 */

import java.util.*;

/**
 * // This is ArrayReader's API interface. // You should not implement it, or
 * speculate about its implementation interface ArrayReader { public int get(int
 * index) {} }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        while (reader.get(high) < target) {
            low = high;
            high *= 2;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int curr = reader.get(mid);
            if (curr == target) {
                return mid;
            }
            if (curr > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}

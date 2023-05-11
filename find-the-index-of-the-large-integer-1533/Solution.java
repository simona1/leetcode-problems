/**
 * LeetCode problem # 1533, 'Find the Index of the Large Integer'
 * https://leetcode.com/problems/find-the-index-of-the-large-integer/
 */

import java.util.*;

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y] 
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */

class Solution {
    public int getIndex(ArrayReader reader) {
        int lo = 0; 
        int hi = reader.length();

        while (hi > 1) {
            hi /= 2;
            int curr = reader.compareSub(lo, lo + hi - 1, lo + hi, lo + 2 * hi - 1);
            if (curr == 0) {
                return lo + 2 * hi;
            }
            if (curr == -1) {
                lo += hi;
            }
        }
        return lo;
    }
}

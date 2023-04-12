
/**
 * LeetCode problem # 1385, 'Find the Distance Value Between Two Arrays'
 * https://leetcode.com/problems/find-the-distance-value-between-two-arrays/
 */

import java.util.*;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int res = 0;

        for (int i = 0; i < arr1.length; ++i) {
            int lo = -1;
            int hi = arr2.length;

            int a = 1;

            while (lo + 1 != hi) {
                int mid = lo + (hi - lo) / 2;
                if (Math.abs(arr2[mid] - arr1[i]) <= d) {
                    a = 0;
                    break;
                }
                if (arr2[mid] > arr1[i]) {
                    hi = mid;
                } else {
                    lo = mid;
                }
            }
            res += a;
        }
        return res;
    }
}
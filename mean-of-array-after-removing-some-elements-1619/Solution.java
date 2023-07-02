
/**
 * LeetCode problem # 1619, 'Mean of Array After Removing Some Elements'
 * https://leetcode.com/problems/mean-of-array-after-removing-some-elements/
 */

import java.util.*;

class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int p = 5 * n / 100;

        int len = n - 2 * p;
        int res = 0;

        for (int i = p; i < n - p; ++i) {
            res += arr[i];
        }

        return (double) res / len * 1.00000;
    }
}

/**
 * LeetCode problem # 1187, 'Make Array Strictly Increasing'
 * https://leetcode.com/problems/make-array-strictly-increasing/
 */

import java.util.*;

class Solution {
    Map<String, Integer> cache = new HashMap<>();

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        int res = solve(0, -1, arr1, arr2);
        return res < 2001 ? res : -1;
    }

    private int solve(int i, int prev, int[] arr1, int[] arr2) {
        if (i == arr1.length) {
            return 0;
        }

        String key = i + "-" + prev;
        Integer fromCache = cache.get(key);
        if (fromCache != null) {
            return fromCache;
        }

        int cost = 2001; // max possible arr1 length
        if (arr1[i] > prev) {
            cost = solve(i + 1, arr1[i], arr1, arr2);
        }

        int index = binarySearch(arr2, prev);
        if (index < arr2.length) {
            cost = Math.min(cost, 1 + solve(i + 1, arr2[index], arr1, arr2));
        }

        cache.put(key, cost);
        return cost;
    }

    private static int binarySearch(int[] arr, int value) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] <= value) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
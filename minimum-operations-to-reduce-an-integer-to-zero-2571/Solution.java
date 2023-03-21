
/**
 * LeetCode problem # 2571, 'Minimum Operations to Reduce an Integer to 0'
 * https://leetcode.com/problems/minimum-operations-to-reduce-an-integer-to-0
 */

import java.util.*;

class Solution {
    static int[] arr = null;

    public Solution() {
        if (arr != null) {
            return;
        }
        arr = new int[1000000];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < arr.length; i *= 2) {
            arr[i] = 1;
            q.add(i);
        }
        while (!q.isEmpty()) {
            int curr = q.remove();
            for (int i = 1;; i *= 2) {
                int a = curr - i;
                if (a < 0) {
                    break;
                }
                if (arr[a] != 0) {
                    continue;
                }
                if (a == 0) {
                    continue;
                }
                arr[a] = arr[curr] + 1;
                q.add(a);
            }
            for (int i = 1;; i *= 2) {
                int a = curr + i;
                if (a >= arr.length) {
                    break;
                }
                if (arr[a] != 0) {
                    continue;
                }
                if (a == 0) {
                    continue;
                }
                arr[a] = arr[curr] + 1;
                q.add(a);
            }
        }
    }

    public int minOperations(int n) {
        return arr[n];
    }
}

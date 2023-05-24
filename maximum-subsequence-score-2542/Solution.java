
/**
 * LeetCode problem # 2542, 'Maximum Subsequence Score'
 * https://leetcode.com/problems/maximum-subsequence-score/
 */

import java.util.*;

class Pair {
    int a;
    int b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Pair[] list = new Pair[n];

        for (int i = 0; i < n; ++i) {
            list[i] = new Pair(nums1[i], nums2[i]);
        }
        Arrays.sort(list, (x, y) -> y.b - x.b);

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
        long sum = 0;
        for (int i = 0; i < k; ++i) {
            int curr = list[i].a;
            sum += curr;
            pq.add(curr);
        }

        long res = sum * list[k - 1].b;
        for (int i = k; i < n; ++i) {
            sum += list[i].a - pq.remove();
            pq.add(list[i].a);
            res = Math.max(res, sum * list[i].b);
        }
        return res;
    }
}
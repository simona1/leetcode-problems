
/**
 * LeetCode problem # 658, 'Find K Closest Elements'
 * https://leetcode.com/problems/find-k-closest-elements/
 */

import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> Math.abs(a - x) == Math.abs(b - x) ? a - b : Math.abs(a - x) - Math.abs(b - x));

        for (int a : arr) {
            pq.add(a);
        }

        List<Integer> res = new ArrayList<>();
        while (k-- > 0) {
            res.add(pq.poll());
        }

        Collections.sort(res);
        return res;
    }
}

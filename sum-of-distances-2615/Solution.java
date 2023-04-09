
/**
 * LeetCode problem # 2615, 'Sum of Distances'
 * https://leetcode.com/problems/sum-of-distances/
 */

import java.util.*;

class Solution {
    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            map.computeIfAbsent(nums[i], val -> new ArrayList<>()).add(i);
        }
        long[] res = new long[n];

        for (List<Integer> indices : map.values()) {
            int size = indices.size();
            if (size == 1) {
                res[indices.get(0)] = 0;
            } else {
                long next = indices.stream().mapToLong(i -> i).sum();
                long prev = 0;

                for (int i = 0; i < size; ++i) {
                    int index = indices.get(i);
                    long tmp = next - ((long) (size - i) * index);
                    tmp += Math.abs(prev - (long) i * index);

                    res[index] = tmp;
                    next -= index;
                    prev += index;
                }
            }
        }
        return res;
    }
}


/**
 * LeetCode problem # 1402, 'Reducing Dishes'
 * https://leetcode.com/problems/reducing-dishes
 */

import java.util.*;

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int n = satisfaction.length;
        int[][] cache = new int[n + 1][n + 1];

        for (int i = 0; i < n; ++i) {
            Arrays.fill(cache[i], -1);
        }
        return maxSatisfactionImpl(satisfaction, cache, 0, 1);
    }

    private int maxSatisfactionImpl(int[] satisfaction, int[][] cache, int index, int time) {
        if (index == satisfaction.length) {
            return 0;
        }

        if (cache[index][time] == -1) {
            cache[index][time] = Math.max(
                    satisfaction[index] * time + maxSatisfactionImpl(satisfaction, cache, index + 1, time + 1),
                    maxSatisfactionImpl(satisfaction, cache, index + 1, time));
        }
        return cache[index][time];
    }
}


/**
 * LeetCode problem # 1183, 'Maximum Number of Ones'
 * https://leetcode.com/problems/maximum-number-of-ones/
 */

import java.util.*;

class Solution {
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        List<Integer> counts = new ArrayList<>();

        for (int r = 0; r < sideLength; ++r) {
            for (int c = 0; c < sideLength; ++c) {
                counts.add((1 + (width - 1 - c) / sideLength) * (1 + (height - 1 - r) / sideLength));
            }
        }

        counts.sort(Comparator.reverseOrder());
        int res = 0;

        for (int i = 0; i < maxOnes; ++i) {
            res += counts.get(i);
        }

        return res;
    }
}
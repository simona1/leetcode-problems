
/**
 * LeetCode problem # 1431, 'Kids With the Greatest Number of Candies'
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies
 */

import java.util.*;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> maxCandies = new ArrayList<Boolean>();
        int maxNum = 0;
        for (int i = 0; i < candies.length; ++i) {
            maxNum = Math.max(maxNum, candies[i]);
        }
        for (int i = 0; i < candies.length; ++i) {
            maxCandies.add(candies[i] + extraCandies >= maxNum);
        }
        return maxCandies;
    }
}


/**
 * LeetCode problem # 135, 'Candy'
 * https://leetcode.com/problems/candy
 */

import java.util.*;

class Solution {

    public int candy(int[] ratings) {

        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for (int i = 1; i < n; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        int res = candies[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            res += candies[i];
        }
        return res;
    }
}

/*
 * - assign 1 candy to each child first - each child must have at least one -
 * traverse from left to right - and distribute canides based on the left
 * neighbor ratings i.e. when the currently examined position is larger than the
 * left, we do candies[i] = candies[i - 1] + 1 - next step we traverse the array
 * from right to left and update the current position to correspond to the
 * required relationship to the right neighbor, i.e. if ratings[i + 1] is less
 * than ratings[i] - then we do candies[i] = Math.max(candies[i], candies[i + 1]
 * + 1);
 * 
 * this is when we also update our result after setting the value
 * 
 */

/**
 * LeetCode problem # 1140, 'Stone Game II'
 * https://leetcode.com/problems/stone-game-ii
 */

import java.util.*;

class Solution {
    public int stoneGameII(int[] piles) {
        Map<String, Integer> cache = new HashMap<>();
        int diff = solve(piles, 1, 0, 0, cache);

        int total = Arrays.stream(piles).sum();
        return (diff + total) / 2;
    }

    //
    // player takes all stones in the first x remaining piles where 1 <= X <= 2M.
    // Then, we set M = max(M, X).

    private int solve(int[] piles, int M, int index, int turn, Map<String, Integer> cache) {
        int n = piles.length;
        if (index >= n) {
            return 0;
        }
        String key = index + "-" + M + "-" + turn;
        Integer cached = cache.get(key);
        if (cached != null) {
            return cached;
        }

        int score = 0;
        int maxScore = Integer.MIN_VALUE;

        if (turn == 0) {
            for (int x = 1; x <= 2 * M && (index + x - 1) < n; ++x) {
                score += piles[index + x - 1];
                maxScore = Math.max(maxScore, solve(piles, Math.max(x, M), index + x, 1, cache) + score);
            }
            cache.put(key, maxScore);
            return maxScore;
        }

        int minScore = Integer.MAX_VALUE;
        for (int x = 1; x <= 2 * M && index + x - 1 < n; ++x) {
            score += piles[index + x - 1];
            minScore = Math.min(minScore, solve(piles, Math.max(x, M), index + x, 0, cache) - score);
        }
        cache.put(key, minScore);
        return minScore;
    }
}

/*
 * 
 * turn = 0 -> Alice's turn = 1 -> Bob's
 * 
 * for each move maximize Alice's score and minimize Bob's
 * 
 * 
 * a + b (alice and bob) need max possible a - b sum of array is a + b
 * 
 * (a + b) + (a - b) = 2 * a so a = (sum of array + max score) / 2
 * 
 */

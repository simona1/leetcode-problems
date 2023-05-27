
/**
 * LeetCode problem # 1406, 'Stone Game III'
 * https://leetcode.com/problems/stone-game-iii/
 */

class Solution {
    Integer[] cache;

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        cache = new Integer[n + 1];

        int aliceScore = computeScoreForAlice(stoneValue, 0);

        if (aliceScore > 0) {
            return "Alice";
        }
        if (aliceScore < 0) {
            return "Bob";
        }
        return "Tie";
    }

    private int computeScoreForAlice(int[] stoneValue, int index) {
        if (index == stoneValue.length) {
            return 0;
        }

        if (cache[index] != null) {
            return cache[index];
        }

        int res = Integer.MIN_VALUE;
        int stone = 0;

        for (int x = 0; x < 3; ++x) {
            int curr = index + x;

            if (curr >= stoneValue.length) {
                continue;
            }

            stone += stoneValue[curr];
            int score = stone - computeScoreForAlice(stoneValue, curr + 1);
            res = Math.max(res, score);
        }
        cache[index] = res;
        return res;
    }
}

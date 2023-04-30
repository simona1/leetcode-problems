
/**
 * LeetCode problem # 2660, 'Determine the Winner of a Bowling Game'
 * https://leetcode.com/problems/determine-the-winner-of-a-bowling-game
 */

import java.util.*;

class Solution {
    public int isWinner(int[] player1, int[] player2) {
        Set<Integer> p1Tens = new HashSet<>();
        Set<Integer> p2Tens = new HashSet<>();

        for (int i = 0; i < player1.length; ++i) {
            if (player1[i] == 10) {
                p1Tens.add(i);
            }
            if (player2[i] == 10) {
                p2Tens.add(i);
            }
        }
        int score1 = computeScore(player1, p1Tens);
        int score2 = computeScore(player2, p2Tens);

        int diff = score1 - score2;
        if (diff > 0) {
            return 1;
        }
        if (diff < 0) {
            return 2;
        }
        return 0;
    }

    private int computeScore(int[] pins, Set<Integer> set) {
        int sum = 0;

        for (int i = 0; i < pins.length; ++i) {
            int prev1 = i - 1;
            int prev2 = i - 2;

            if (set.contains(prev1) || set.contains(prev2)) {
                sum += pins[i] * 2;
            } else {
                sum += pins[i];
            }
        }
        return sum;
    }
}

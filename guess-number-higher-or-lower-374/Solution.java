
/**
 * LeetCode problem # 374, 'Guess Number Higher or Lower'
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 */

import java.util.*;

/**
 * Forward declaration of guess API.
 * 
 * @param num your guess
 * @return -1 if num is higher than the picked number 1 if num is lower than the
 *         picked number otherwise return 0 int guess(int num);
 */

class GuessGame {
    static int number;

    public static int guess(int value) {
        if (value == number) {
            return 0;
        }
        if (value < number) {
            return -1;
        }
        return 1;
    }
}

class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int curr = guess(mid);
            if (curr == 0) {
                return mid;
            }
            if (curr == -1) {
                high = mid - 1;
            } else if (curr == 1) {
                low = mid + 1;
            }

        }
        return -1;
    }
}
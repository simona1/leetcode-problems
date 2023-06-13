
/**
 * LeetCode problem # 1503, 'Last Moment Before All Ants Fall Out of a Plank'
 * https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/
 */

import java.util.*;

class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int totalDistLeft = 0;
        int totalDistRight = 0;

        if (left.length == 0) {
            totalDistLeft = 0;
        } else {
            totalDistLeft = Arrays.stream(left).max().getAsInt();
        }
        if (right.length == 0) {
            totalDistRight = n;
        } else {
            totalDistRight = Arrays.stream(right).min().getAsInt();
        }
        return Math.max(totalDistLeft, n - totalDistRight);
    }
}

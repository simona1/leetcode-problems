
/**
 * LeetCode problem # 1552, 'Magnetic Force Between Two Balls'
 * https://leetcode.com/problems/magnetic-force-between-two-balls
 */

import java.util.*;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int res = -1;

        int low = -1;
        int high = position[position.length - 1];

        while (low + 1 != high) {
            int mid = (low + high) / 2;

            if (canMakeDistance(position, mid, m)) {
                res = Math.max(res, mid);
                low = mid;
            } else {
                high = mid;
            }
        }
        return res;
    }

    public boolean canMakeDistance(int[] position, int mid, int n) {
        int count = 1;
        int start = position[0];

        for (int i = 1; i < position.length; ++i) {
            if (position[i] - start >= mid) {
                start = position[i];
                ++count;
                if (count == n) {
                    return true;
                }
            }
        }
        return false;
    }
}

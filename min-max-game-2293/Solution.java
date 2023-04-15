
/**
 * LeetCode problem # 2293, 'Min Max Game'
 * https://leetcode.com/problems/min-max-game/
 */

import java.util.*;

class Solution {
    public int minMaxGame(int[] nums) {

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; ++i) {
            q.add(nums[i]);
        }

        boolean isMin = true;

        while (q.size() != 1) {
            int i = q.remove();
            int j = q.remove();
            if (isMin) {
                q.add(Math.min(i, j));
            } else {
                q.add(Math.max(i, j));
            }
            isMin = !isMin;
        }
        return q.remove();
    }
}

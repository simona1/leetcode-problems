
/**
 * LeetCode problem # 403, 'Frog Jump'
 * https://leetcode.com/problems/frog-jump/
 */

import java.util.*;

class Solution {
    public boolean canCross(int[] stones) {
        HashSet<Integer> validPos = new HashSet<>();
        for (int stone : stones) {
            validPos.add(stone);
        }
        if (!validPos.contains(0)) {
            return false;
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0, 0 });

        Set<String> vis = new HashSet<>();
        vis.add(0 + " " + 0);

        while (!q.isEmpty()) {
            int[] curr = q.remove();

            int currPos = curr[0];
            int currSteps = curr[1];
            int currK = curr[2];

            if (currPos == stones[stones.length - 1]) {
                return true;
            }

            // jumps
            int i = -1;
            while (i <= 1) {
                int newPos = currPos + currK + i;
                String toCache = newPos + " " + (currK + i);

                if (newPos >= 0 && !vis.contains(toCache) && validPos.contains(newPos)) {
                    vis.add(toCache);
                    q.add(new int[] { newPos, currSteps + 1, currK + i });
                }
                ++i;
            }
        }
        return false;
    }
}

// add 3 things to queue: current position, steps to reach it and k to reach it
// position, k - each position can be reached with a different k

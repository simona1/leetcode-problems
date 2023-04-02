
/**
 * LeetCode problem # 2300, 'Successful Pairs of Spells and Potions'
 * https://leetcode.com/problems/successful-pairs-of-spells-and-potions/
 */

import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int[] res = new int[spells.length];
        int n = potions.length;

        int maxPotion = potions[n - 1];

        for (int i = 0; i < spells.length; ++i) {
            int spell = spells[i];

            long minPotion = (long) Math.ceil((1.0 * success) / spell);
            if (minPotion > maxPotion) {
                res[i] = 0;
                continue;
            }

            int startIndex = binarySearch(potions, (int) minPotion - 1);
            res[i] = n - startIndex;
        }
        return res;
    }

    private int binarySearch(int[] nums, int target) {
        int lo = -1;
        int hi = nums.length;

        while (lo + 1 != hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] <= target) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return hi;
    }
}
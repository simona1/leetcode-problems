
/**
 * LeetCode problem # 1760, 'Minimum Limit of Balls in a Bag'
 * https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag
 */

class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1;
        int high = maxElem(nums);
        if (high == 1) {
            return high;
        }

        while (low + 1 != high) {
            int mid = low + (high - low) / 2;
            int minimumNeededOps = 0;

            for (int num : nums) {
                minimumNeededOps += (num / mid + (num % mid != 0 ? 1 : 0)) - 1;
            }

            if (minimumNeededOps > maxOperations) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }

    private int maxElem(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }
}

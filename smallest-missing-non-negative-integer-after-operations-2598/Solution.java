/**
 * LeetCode problem # 2598, 'Smallest Missing Non-negative Integer After
 * Operations'
 * https://leetcode.com/problems/smallest-missing-non-negative-integer-after-operations
 */

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] freq = new int[value];

        for (int num : nums) {
            int rem = num % value;
            if (rem < 0) {
                rem += value;
            }
            ++freq[rem];
        }

        int count = 0;
        while (true) {
            int index = count % value;

            if (freq[index] > 0) {
                ++count;

                --freq[index];
                continue;
            }
            break;
        }
        return count;
    }
}

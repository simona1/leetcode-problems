
/**
 * LeetCode problem # 137, 'Single Number II'
 * https://leetcode.com/problems/single-number-ii/
 */

import java.util.*;

class Solution {
    public int singleNumber(int[] nums) {
        Set<Long> set = new HashSet<>();
        long sum = 0;
        for (int num : nums) {
            set.add((long) num);
            sum += num;
        }

        long setSum = 0;
        for (long num : set) {
            setSum += num;
        }

        return (int) ((3 * setSum - sum) / 2);
    }
}
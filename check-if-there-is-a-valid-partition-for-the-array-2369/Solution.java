/**
 * LeetCode problem # 2369, 'Check if There is a Valid Partition For The Array'
 * https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/
 */

import java.util.*;

class Solution {
    Map<Integer, Boolean> cache = new HashMap<>();

    public boolean validPartition(int[] nums) {
        int n = nums.length - 1;
        cache.put(-1, true);
        return isValidPrefixArr(nums, n);

    }

    private boolean isValidPrefixArr(int[] nums, int index) {
        Boolean cachedValue = cache.get(index);
        if (cachedValue != null) {
            return cachedValue;
        }

        boolean res = false;
        
        // check that two are equal
        if (index > 0 && nums[index] == nums[index - 1]) {
            res = res || isValidPrefixArr(nums, index - 2);
        }

        // check that three are equal
        if (index > 1 && nums[index] == nums[index - 1] && nums[index - 1] == nums[index - 2]) {
            res = res || isValidPrefixArr(nums, index - 3);
        }

        // check for 3 consecutively increasing numbers
        if (index > 1 && nums[index] == nums[index - 1] + 1 && nums[index - 1] == nums[index - 2] + 1) {
            res = res || isValidPrefixArr(nums, index - 3);
        }
        cache.put(index, res);
        return res;
    }
}
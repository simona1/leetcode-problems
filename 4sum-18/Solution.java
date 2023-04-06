
/**
 * LeetCode problem # 18, '4Sum'
 * https://leetcode.com/problems/4sum/
 */

import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n - 2; ++j) {
                int start = j + 1;
                int end = n - 1;
                List<Integer> curr;

                while (start < end) {
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[start] + (long) nums[end];
                    // System.out.println(sum);
                    if (sum == target) {
                        curr = new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        set.add(new ArrayList<Integer>(curr));
                        start++;
                        end--;
                    } else if (sum > target) {
                        end--;
                    } else {
                        start++;

                    }
                }

            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.addAll(set);
        return res;
    }
}

/*
* LeetCode problem # 2597, 'The Number of Beautiful Subsets'
* https://leetcode.com/problems/the-number-of-beautiful-subsets
*/

import java.util.*;

class Solution {
    int count = 0;

    public int beautifulSubsets(int[] nums, int k) {
        count = 0;
        traverse(nums, 0, new Stack<Integer>(), k, new HashMap<>());
        return count - 1;
    }

    private void traverse(int[] nums, int index, Stack<Integer> st, int k, Map<Integer, Integer> map) {
        if (index == nums.length) {
            ++count;
            return;
        }

        traverse(nums, index + 1, st, k, map);
        int curr = nums[index];

        if (map.containsKey(curr + k) || map.containsKey(curr - k)) {
            return;
        }

        st.push(curr);
        map.put(curr, map.getOrDefault(curr, 0) + 1);
        traverse(nums, index + 1, st, k, map);
        st.pop();

        map.put(curr, map.get(curr) - 1);
        if (map.get(curr) == 0) {
            map.remove(curr);
        }
    }
}

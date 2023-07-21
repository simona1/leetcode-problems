
/**
 * LeetCode problem # 78, 'Subsets' https://leetcode.com/problems/subsets/
 */
import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        generateAllSubsets(4);
        subsetsImpl(0, nums, curr, res);
        return res;
    }

    private void subsetsImpl(int index, int[] nums, List<Integer> curr, List<List<Integer>> res) {
        if (index >= nums.length) {
            res.add(new ArrayList<>(curr));
        } else {
            curr.add(nums[index]);
            subsetsImpl(index + 1, nums, curr, res);
            curr.remove(curr.size() - 1);
            subsetsImpl(index + 1, nums, curr, res);
        }
    }

    public void generateAllSubsets(int n) {
        int size = 1 << n;
        // 1, 10, 100, 1000, 10000
        // 1 = 1 * b^0
        // 10 = 1 * b^1 + 0 * b^0
        // 100 = 1 * b^2 + 0 * b^1 + 0 * b^0

        for (int i = 0; i < size; ++i) {
            // String curr = leftPad(Integer.toString(i, 2), n);
            // List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();

            // 1000 [0] [0]
            // 1000 n - 1 zeroes
            // 0100 n - 2 zeroes
            // 0010 n - 3 zeroes
            // 0001 n - 4 zeroes

            // 101010111100011111
            // 000000100000000000 10 = 2^1
            for (int j = 0; j < n; ++j) {
                // int bitmask = 1 << j;
                if ((i & (1 << j)) != 0) {
                    list2.add(j);
                }
            }
            System.out.println(list2);
        }

    }
}


/**
 * LeetCode problem # 1569, 'Number of Ways to Reorder Array to Get Same BST'
 * https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/
 */

import java.util.*;

class Solution {
    static long MOD = (long) Math.pow(10, 9) + 7;
    private long[][] data;

    public int numOfWays(int[] nums) {
        int n = nums.length;

        // precomputes binomial coefficients (use Pascal's triangle)
        // number of rows needed is max the size of nums
        // Pascal's triangle numbers -> sum of the two numbers directly above it
        // will use it to get combinations, `n - 1 Choose leftNodes` = (n - 1)! /
        // leftNodes! * (n - 1 - leftNodes)

        data = new long[n][n];
        for (int i = 0; i < n; ++i) {
            data[i][0] = data[i][i] = 1;
        }

        for (int i = 2; i < n; ++i) {
            for (int j = 1; j < i; ++j) {
                data[i][j] = (data[i - 1][j - 1] + data[i - 1][j]) % MOD;
            }
        }

        // converts an array of primitive values (nums) into a List object,
        // where each element of the array is wrapped into its corresponding wrapper
        // class
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return (int) ((numOfWaysImpl(list) - 1) % MOD);
    }

    private long numOfWaysImpl(List<Integer> nums) {
        int size = nums.size();
        if (size < 3) {
            return 1;
        }

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        // first node is the root; we partition the nums smaller than root to the left
        // and
        // those larger than root to the right
        for (int i = 1; i < size; ++i) {
            int root = nums.get(0);
            int curr = nums.get(i);
            if (curr < root) {
                left.add(curr);
            } else {
                right.add(curr);
            }
        }
        long waysLeft = numOfWaysImpl(left);
        long waysRight = numOfWaysImpl(right);

        return (((waysLeft * waysRight) % MOD) * data[size - 1][left.size()]) % MOD;

    }
}
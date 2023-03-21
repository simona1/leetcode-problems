
/**
 * LeetCode problem # 2587, 'Rearrange Array to Maximize Prefix Score'
 * https://leetcode.com/problems/rearrange-array-to-maximize-prefix-score
 */

import java.util.*;

class Solution {
    public int maxScore(int[] nums) {
        int[] newNums = rearrangeToMaximizeScore(nums);

        long[] prefixSums = prefixSum(newNums);

        int res = 0;
        for (long p : prefixSums) {
            if (p > 0) {
                ++res;
            }
        }
        return res;

    }

    public long[] prefixSum(int[] arr) {
        int n = arr.length;
        long[] prefix = new long[n + 1];
        prefix[0] = 0;

        for (int i = 1; i <= n; ++i) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        return prefix;
    }

    public int[] rearrangeToMaximizeScore(int[] arr) {
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        for (int a : arr) {
            if (a > 0) {
                positive.add(a);
            } else {
                negative.add(a);
            }
        }

        Collections.sort(positive, Collections.reverseOrder());
        Collections.sort(negative, Collections.reverseOrder());
        positive.addAll(negative);
        int[] rearranged = positive.stream().mapToInt(Integer::intValue).toArray();
        return rearranged;
    }
}

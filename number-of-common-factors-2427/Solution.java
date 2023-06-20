
/**
 * LeetCode problem # 2427, 'Number of Common Factors'
 * https://leetcode.com/problems/number-of-common-factors/
 */

import java.util.*;

class Solution {
    public int commonFactors(int a, int b) {
        Set<Integer> fa = findFactors(a);
        Set<Integer> fb = findFactors(b);

        int res = 0;
        for (int num : fa) {
            if (fb.contains(num)) {
                ++res;
            }
        }
        return res;
    }

    private Set<Integer> findFactors(int num) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= num; ++i) {
            if (num % i == 0) {
                set.add(i);
            }
        }
        return set;
    }
}

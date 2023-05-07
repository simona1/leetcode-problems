
/**
 * LeetCode problem # 2605, 'Form Smallest Number From Two Digit Arrays'
 * https://leetcode.com/problems/form-smallest-number-from-two-digit-arrays
 */

import java.util.*;

class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int res = Integer.MAX_VALUE;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }

        List<Integer> common = new ArrayList<>();

        for (int n : set1) {
            if (set2.contains(n)) {
                common.add(n);
            }
        }

        if (common.size() > 0) {
            for (int c : common) {
                res = Math.min(res, c);
            }
            return res;
        }
        int sm1 = Integer.MAX_VALUE;
        int sm2 = Integer.MAX_VALUE;

        for (int num : set1) {
            sm1 = Math.min(sm1, num);
        }

        for (int num : set2) {
            sm2 = Math.min(sm2, num);
        }
        return sm1 > sm2 ? Integer.parseInt(sm2 + "" + sm1) : Integer.parseInt(sm1 + "" + sm2);
    }
}

/**
 * LeetCode problem # 728, 'Self Dividing Numbers'
 * https://leetcode.com/problems/self-dividing-numbers
 */

import java.util.*;

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();

        for (int i = left; i <= right; ++i) {
            if (isSelfDividing(i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean isSelfDividing(int n) {
        String s = n + "";
        for (int i = 0; i < s.length(); ++i) {
            int curr = s.charAt(i) - '0';

            if (curr == 0 || n % curr != 0) {
                return false;
            }
        }
        return true;
    }
}

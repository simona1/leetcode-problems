
/**
 * LeetCode problem # 1502, 'Can Make Arithmetic Progression From Sequence'
 * https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
 */

import java.util.*;

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; ++i) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }
        return true;
    }
}
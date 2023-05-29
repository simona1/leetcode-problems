/**
 * LeetCode problem # 2566, 'Maximum Difference by Remapping a Digit'
 * https://leetcode.com/problems/maximum-difference-by-remapping-a-digit/
 */

class Solution {
    public int minMaxDifference(int num) {
        char[] digitsMax = String.valueOf(num).toCharArray();
        char[] digitsMin = String.valueOf(num).toCharArray();

        int index = 0;
        for (int i = 0; i < digitsMax.length; ++i) {
            if (digitsMax[index] == '9') {
                ++index;
            } else {
                break;
            }
        }

        if (index < digitsMax.length) {
            int digit = digitsMax[index];
            for (int i = 0; i < digitsMax.length; ++i) {
                if (digitsMax[i] == digit) {
                    digitsMax[i] = '9';
                }
            }
        }

        char prev2 = digitsMin[0];
        for (int i = 0; i < digitsMin.length; ++i) {
            if (digitsMin[i] == prev2) {
                digitsMin[i] = '0';
            }
        }

        String maxS = new String(digitsMax);
        String minS = new String(digitsMin);
        return Integer.parseInt(maxS) - Integer.parseInt(minS);

    }
}
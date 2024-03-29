/**
 * LeetCode problem # 319, 'Bulb Switcher'
 * https://leetcode.com/problems/bulb-switcher/
 */

class Solution {
    public int bulbSwitch(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; ++i) {
            ++count;
        }
        return count;
    }
}
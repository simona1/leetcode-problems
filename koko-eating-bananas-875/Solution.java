/*
 * LeetCode problem # 875, 'Koko Eating Bananas'
 * https://leetcode.com/problems/koko-eating-bananas
 */

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = 1;

        for (int pile : piles) {
            hi = Math.max(hi, pile);
        }

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int hoursNeeded = 0;

            for (int pile : piles) {
                hoursNeeded += (pile + mid - 1) / mid;
            }

            if (hoursNeeded <= h) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return hi;
    }
}

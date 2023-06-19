
/**
 * LeetCode problem # 2739, 'Total Distance Traveled'
 * https://leetcode.com/problems/total-distance-traveled/
 */

class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int used = 0;
        while (mainTank >= 5) {
            mainTank -= 5;
            used += 5;
            if (additionalTank > 0) {
                mainTank++;
                additionalTank--;
            }
        }
        if (mainTank > 0) {
            used += mainTank;
        }
        return used * 10;
    }
}

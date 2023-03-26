/**
 * LeetCode problem # 2600, 'K Items With the Maximum Sum'
 * https://leetcode.com/problems/k-items-with-the-maximum-sum
 */

class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes) {
            return k;
        }
        int res = Math.min(numOnes, k);

        k -= numOnes + numZeros;
        if (k < 0) {
            return res;
        }

        res -= Math.min(k, numNegOnes);
        return res;
    }
}


/**
 * LeetCode problem # 1013, 'Partition Array Into Three Parts With Equal Sum'
 * https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
 */

import java.util.*;

class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 3 != 0) {
            return false;
        }

        int parts = 0;
        int currSum = 0;
        int targetSum = sum / 3;

        for (int i = 0; i < arr.length; ++i) {
            currSum += arr[i];
            if (currSum == targetSum && parts <= 2) {
                parts++;
                currSum = 0;
            }
        }
        return (parts == 3 && currSum == 0);
    }
}
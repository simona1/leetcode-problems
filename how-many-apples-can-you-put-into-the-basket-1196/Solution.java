
/**
 * LeetCode problem # 1196, 'How Many Apples Can You Put into the Basket'
 * https://leetcode.com/problems/how-many-apples-can-you-put-into-the-basket/
 */

import java.util.*;

class Solution {
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int apples = 0;
        int num = 0;

        for (int i = 0; i < weight.length && num + weight[i] <= 5000; ++i) {
            apples++;
            num += weight[i];
        }

        return apples;
    }
}

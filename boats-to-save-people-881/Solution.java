
/**
 * LeetCode problem # 881, 'Boats to Save People'
 * https://leetcode.com/problems/boats-to-save-people/
 */

import java.util.*;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int i = 0;
        int j = people.length - 1;
        int res = 0;

        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                ++i;
            }
            --j;
            ++res;
        }
        return res;
    }
}

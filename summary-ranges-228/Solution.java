
/**
 * LeetCode problem # 228, 'Summary Ranges'
 * https://leetcode.com/problems/summary-ranges/
 */

import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {

        List<String> res = new ArrayList<>();
        Stack<int[]> st = new Stack<>();

        for (int num : nums) {
            if (st.isEmpty() || st.peek()[1] != num - 1) {
                st.push(new int[] { num, num });
            } else {
                st.peek()[1] = num;
            }
        }

        for (int[] curr : st) {
            int a = curr[0];
            int b = curr[1];

            res.add(a != b ? (a + "->" + b) : a + "");
        }
        return res;
    }
}

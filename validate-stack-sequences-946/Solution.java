
/**
 * LeetCode problem # 946, 'Validate Stack Sequences'
 * https://leetcode.com/problems/validate-stack-sequences/
 */

import java.util.*;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;

        Stack<Integer> st = new Stack<>();

        int count = 0;
        for (int num : pushed) {
            st.push(num);
            while (!st.isEmpty() && st.peek() == popped[count]) {
                st.pop();
                ++count;
            }
        }
        return count == n;
    }
}
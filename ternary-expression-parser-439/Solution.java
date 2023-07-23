
/**
 * LeetCode problem # 439, 'Ternary Expression Parser'
 * https://leetcode.com/problems/ternary-expression-parser/
 */

import java.util.*;

class Solution {
    public String parseTernary(String expression) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); ++i) {
            char c = expression.charAt(i);
            if (c == '?') {
                dq.push(i);
                continue;
            }

            if (c == ':') {
                int index = dq.pop();
                map.put(index, i);
                continue;
            }
        }
        return solve(expression, 0, expression.length() - 1, map);
    }

    private String solve(String expression, int start, int end, Map<Integer, Integer> map) {
        if (start == end) {
            return expression.substring(start, start + 1);
        }

        int colonIndex = map.get(start + 1);
        if (expression.charAt(start) == 'T') {
            return solve(expression, start + 2, colonIndex - 1, map);
        }
        return solve(expression, colonIndex + 1, end, map);
    }
}
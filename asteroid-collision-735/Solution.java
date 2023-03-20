/*
* LeetCode problem # 735, 'Asteroid Collision'
* https://leetcode.com/problems/asteroid-collision
*/

import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> ast = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < asteroids.length; ++i) {
            int curr = asteroids[i];
            if (curr > 0) {
                st.push(curr);
            }

            while ((!st.isEmpty()) && (st.peek() < -(curr))) {
                st.pop();
            }

            if (((!st.isEmpty()) && (st.peek() > Math.abs(curr)))) {
                continue;
            }

            if ((!st.isEmpty()) && (curr + st.peek() == 0)) {
                st.pop();
                continue;
            }

            if (curr < 0) {
                ast.add(curr);
            }
        }

        ast.addAll(st);
        int[] res = new int[ast.size()];

        for (int i = 0; i < res.length; ++i) {
            res[i] = ast.get(i);
        }
        return res;
    }
}

/*
 * LeetCode problem # 443, 'String Compression'
 * https://leetcode.com/problems/string-compression
 */

import java.util.Stack;

class Solution {
    public int compress(char[] chars) {
        Stack<Pair> st = new Stack<>();

        for (char c : chars) {
            if (st.isEmpty()) {
                st.push(new Pair(c, 1));
            } else {
                char curr = st.peek().c;
                if (curr == c) {
                    st.peek().count++;
                } else {
                    st.push(new Pair(c, 1));
                }
            }
        }

        int index = 0;
        for (Pair p : st) {
            String countStr = String.valueOf(p.count);
            chars[index++] = p.c;
            if (p.count != 1) {
                for (int j = 0; j < countStr.length(); ++j) {
                    chars[index++] = countStr.charAt(j);
                }
            }
        }
        return index;
    }
}

class Pair {
    char c;
    int count;

    public Pair(char c, int count) {
        this.c = c;
        this.count = count;
    }
}

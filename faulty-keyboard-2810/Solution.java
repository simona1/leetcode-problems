
/**
 * LeetCode problem # 2810, 'Faulty Keyboard'
 * https://leetcode.com/problems/faulty-keyboard/
 */

import java.util.*;

class Solution {
    public String finalString(String s) {
        Deque<Character> dq = new LinkedList<>();
        boolean shouldReverse = false;

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == 'i') {
                shouldReverse = shouldReverse ? false : true;
            } else if (shouldReverse) {
                dq.addFirst(c);
            } else {
                dq.addLast(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            if (shouldReverse) {
                sb.append(dq.removeLast());
            } else {
                sb.append(dq.removeFirst());
            }
        }
        return sb.toString();
    }
}
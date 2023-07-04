
/**
 * LeetCode problem # 1700, 'Number of Students Unable to Eat Lunch'
 * https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
 */

import java.util.*;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        for (int student : students) {
            q.add(student);
        }

        for (int i = 0; i < sandwiches.length; ++i) {
            int size = q.size();
            int attempts = 0;

            while (!q.isEmpty()) {
                if (q.peek() == sandwiches[i]) {
                    q.remove();
                    break;
                } else {
                    ++attempts;
                    q.add(q.remove());
                    if (size == attempts) {
                        return q.size();
                    }
                }
            }
        }
        return 0;
    }
}

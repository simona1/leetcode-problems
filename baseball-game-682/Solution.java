
/**
* LeetCode problem # 682, 'Baseball Game'
* https://leetcode.com/problems/baseball-game
*/

import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> record = new Stack<>();

        for (int i = 0; i < operations.length; ++i) {
            if (operations[i].equals("C")) {
                if (!record.isEmpty()) {
                    record.pop();
                }
                continue;
            } else if (operations[i].equals("D")) {
                if (record.size() > 0) {
                    int last = record.peek();
                    record.push(last * 2);
                }
                continue;
            } else if (operations[i].equals("+")) {
                if (record.size() >= 2) {
                    int last = record.pop();
                    int prevToLast = record.peek();
                    record.push(last);
                    int next = last + prevToLast;
                    record.push(next);
                }
                continue;
            } else {
                int curr = Integer.parseInt(operations[i]);
                record.push(curr);
            }
        }

        int res = 0;
        for (int num : record) {
            res += num;
        }
        return res;
    }
}

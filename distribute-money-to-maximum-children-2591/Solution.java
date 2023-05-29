
/**
 * LeetCode problem # 2591, 'Distribute Money to Maximum Children'
 * https://leetcode.com/problems/distribute-money-to-maximum-children/
 */

class Solution {
    public int distMoney(int money, int children) {
        if (children > money) {
            return -1;
        }
        if (money < 8) {
            return 0;
        }

        int d = money / 8;
        int rem = money % 8;
        if (d == children && rem == 0) {
            return children;
        }
        if (d >= children) {
            return children - 1;
        }
        if (rem == 4 && children - d == 1) {
            return children - 2;
        }
        if (rem >= children - d) {
            return d;
        }
        int curr = children - d;
        while (rem < curr) {
            ++curr;
            rem += 8;
            --d;
        }
        return d;

    }
}

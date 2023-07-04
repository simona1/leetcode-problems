
/**
 * LeetCode problem # 933, 'Number of Recent Calls'
 * https://leetcode.com/problems/number-of-recent-calls/
 */

import java.util.*;

class RecentCounter {
    LinkedList<Integer> timeInterval;

    public RecentCounter() {
        this.timeInterval = new LinkedList<>();
    }

    public int ping(int t) {
        this.timeInterval.addLast(t);

        while (this.timeInterval.getFirst() < t - 3000) {
            this.timeInterval.removeFirst();
        }
        return this.timeInterval.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter(); int param_1 = obj.ping(t);
 */
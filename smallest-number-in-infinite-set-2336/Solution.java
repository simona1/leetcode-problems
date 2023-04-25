
/**
 * LeetCode problem # 2336, 'Smallest Number in Infinite Set'
 * https://leetcode.com/problems/smallest-number-in-infinite-set/
 */

import java.util.*;

class SmallestInfiniteSet {

    PriorityQueue<Integer> pq;
    int curr;

    public SmallestInfiniteSet() {
        this.pq = new PriorityQueue<>();
        this.curr = 1;
    }

    public int popSmallest() {
        int res = curr;

        if (pq.isEmpty() || pq.peek() >= curr) {
            ++curr;
        } else if (pq.peek() < res) {
            res = pq.poll();
        }

        while (!pq.isEmpty() && pq.peek() == res) {
            pq.poll();

        }

        return res;
    }

    public void addBack(int num) {
        pq.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet(); int param_1 =
 * obj.popSmallest(); obj.addBack(num);
 */
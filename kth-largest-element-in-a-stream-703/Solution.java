
/**
 * LeetCode problem # 703, 'Kth Largest Element in a Stream'
 * https://leetcode.com/problems/kth-largest-element-in-a-stream
 */

import java.util.*;

class KthLargest {
    private PriorityQueue<Integer> pq;
    private static int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;

        this.pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }
        while (pq.size() > k) {
            pq.remove();
        }
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > k) {
            pq.remove();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such: KthLargest
 * obj = new KthLargest(k, nums); int param_1 = obj.add(val);
 */
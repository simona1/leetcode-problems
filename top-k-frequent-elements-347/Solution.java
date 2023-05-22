
/**
 * LeetCode problem # 347, 'Top K Frequent Elements'
 * https://leetcode.com/problems/top-k-frequent-elements/
 */

import java.util.*;

class Pair {
    int num;
    int f;

    public Pair(int n, int f) {
        this.num = n;
        this.f = f;
    }

    @Override
    public String toString() {
        return this.num + ": " + this.f;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(k, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.f - b.f;
            }
        });

        for (Integer num : freq.keySet()) {
            Pair curr = new Pair(num, freq.get(num));
            pq.add(curr);
            if (pq.size() > k) {
                pq.remove();
            }
        }

        int[] res = new int[k];
        int index = 0;
        while (index < k) {
            res[index] = pq.remove().num;
            ++index;
        }
        return res;

    }
}

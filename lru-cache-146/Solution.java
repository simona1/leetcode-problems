
/**
 * LeetCode problem # 146, 'LRU Cache'
 * https://leetcode.com/problems/lru-cache/
 */

import java.util.*;

class LRUCache {
    Queue<Integer> q = new LinkedList<>();
    Map<Integer, Integer> cache = new HashMap<>();
    Map<Integer, Integer> count = new HashMap<>();
    int cap = 0;

    public LRUCache(int capacity) {
        this.cap = capacity;

    }

    public int get(int key) {
        Integer res = cache.get(key);
        if (res == null) {
            return -1;
        }
        q.add(key);
        count.put(key, count.get(key) + 1);
        return res;
    }

    public void put(int key, int value) {
        cache.put(key, value);
        count.put(key, count.getOrDefault(key, 0) + 1);
        q.add(key);

        int size = cache.size();
        while (size > this.cap) {

            int curr = q.remove();
            int tmp = count.get(curr);
            count.put(curr, tmp - 1);

            if (tmp == 1) {
                count.remove(curr);
                cache.remove(curr);
                --size;
            }
        }
    }

}
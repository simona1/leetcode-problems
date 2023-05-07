
/**
 * LeetCode problem # 2671, 'Frequency Tracker'
 * https://leetcode.com/problems/frequency-tracker
 */

import java.util.*;

class FrequencyTracker {
    Map<Integer, Integer> map;
    int[] freq;

    public FrequencyTracker() {
        map = new HashMap<>();
        freq = new int[100001];
    }

    public void add(int number) {
        int curr = map.getOrDefault(number, 0);
        int next = curr + 1;
        map.put(number, next);
        freq[curr]--;
        freq[next]++;
    }

    public void deleteOne(int number) {
        if (map.containsKey(number)) {
            int curr = map.get(number);
            int next = curr - 1;
            if (next == 0) {
                map.remove(number);
            } else {
                map.put(number, next);
            }
            freq[curr]--;
            freq[next]++;
        }
    }

    public boolean hasFrequency(int frequency) {
        return freq[frequency] > 0;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker(); obj.add(number);
 * obj.deleteOne(number); boolean param_3 = obj.hasFrequency(frequency);
 */

/*
 * LeetCode problem # 1675, 'Minimize Deviation in Array'
 * https://leetcode.com/problems/minimize-deviation-in-array/
 */

import java.util.PriorityQueue;

class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> apq = new PriorityQueue<>((a, b) -> a - b);
        PriorityQueue<Integer> dpq = new PriorityQueue<>((a, b) -> b - a);

        int smallest = Integer.MAX_VALUE;
        int largest = 0;
        int res = Integer.MAX_VALUE;

        for (int num : nums) {
            largest = Math.max(num, largest);
            smallest = Math.min(num, smallest);
            apq.add(num);
        }
        res = largest - smallest;

        while (!apq.isEmpty()) {
            int curr = apq.peek();
            res = Math.min(res, largest - curr);
            if (curr % 2 == 1) {
                largest = Math.max(largest, curr * 2);
                apq.add(apq.remove() * 2);
            } else {
                break;
            }
        }

        smallest = apq.peek();
        while (!apq.isEmpty()) {
            dpq.add(apq.remove());
        }

        while (!dpq.isEmpty()) {
            int curr = dpq.peek();
            res = Math.min(res, curr - smallest);
            if (curr % 2 == 0) {
                smallest = Math.min(smallest, curr / 2);
                dpq.add(dpq.remove() / 2);
            } else {
                break;
            }
        }
        return res;
    }
}


/**
 * LeetCode problem # 253, 'Meeting Rooms II'
 * https://leetcode.com/problems/meeting-rooms-ii
 */

import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int[] interval) {
        this.start = interval[0];
        this.end = interval[1];
    }
}

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        List<Interval> list = new ArrayList<>();
        for (int[] a : intervals) {
            list.add(new Interval(a));
        }

        Collections.sort(list, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        int n = intervals.length;

        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(n, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });

        pq.offer(list.get(0));

        for (int i = 1; i < n; ++i) {
            // get earliest finishing meeting
            Interval curr = pq.poll();
            Interval fromList = list.get(i);
            if (fromList.start >= curr.end) {
                // if mtgs don't clash we can merge the intervals
                curr.end = fromList.end;
            } else {
                // can't merge add to queue
                pq.offer(fromList);
            }
            // add back the modified interval
            pq.offer(curr);
        }
        return pq.size();

    }
}

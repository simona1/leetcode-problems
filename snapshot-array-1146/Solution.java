
/**
 * LeetCode problem # 1146, 'Snapshot Array'
 * https://leetcode.com/problems/snapshot-array/
 */

import java.util.*;

class SnapshotArray {
    private List<int[]>[] data;
    private int snapID = 0;

    public SnapshotArray(int length) {
        data = new ArrayList[length];
        for (int i = 0; i < length; ++i) {
            data[i] = new ArrayList<>();
            data[i].add(new int[] { -1, 0 });
        }

    }

    public void set(int index, int val) {
        data[index].add(new int[] { snapID, val });
    }

    public int snap() {
        return snapID++;
    }

    public int get(int index, int snap_id) {
        List<int[]> curr = data[index];
        int lo = -1;
        int hi = curr.size();
        while (lo + 1 != hi) {
            int mid = lo + (hi - lo) / 2;
            if (curr.get(mid)[0] <= snap_id) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return curr.get(lo)[1];
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length); obj.set(index,val); int
 * param_2 = obj.snap(); int param_3 = obj.get(index,snap_id);
 */
/*
 * LeetCode problem # 2570, 'Merge Two 2D Arrays by Summing Values'
 * https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/
 *
 */

import java.util.*;

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<Pair> list = new ArrayList<>();
        for (int[] a : nums1) {
            Pair p = new Pair(a[0], a[1]);
            list.add(p);
        }
        for (int[] b : nums2) {
            Pair p = new Pair(b[0], b[1]);
            list.add(p);
        }
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return Integer.compare(p1.getId(), p2.getId());
            }
        });
        Set<Integer> ids = new HashSet<>();
        for (Pair p : list) {
            ids.add(p.id);
        }
        int[][] res = new int[ids.size()][2];
        Map<Integer, Pair> map = new HashMap<>();
        for (int i = 0; i < list.size(); ++i) {
            Pair p = list.get(i);
            Pair curr = map.get(p.id);
            if (curr == null) {
                map.put(p.id, p);
            } else {
                map.put(p.id, new Pair(p.id, p.val + curr.val));
            }
        }
        int index = 0;

        Integer[] arr = ids.toArray(new Integer[0]);
        Arrays.sort(arr);
        for (int id : arr) {
            Pair p = map.get(id);
            res[index] = new int[] { p.id, p.val };
            ++index;
        }
        return res;
    }
}

class Pair {
    int id;
    int val;

    public Pair(int id, int val) {
        this.id = id;
        this.val = val;
    }

    public int getId() {
        return id;
    }

    public int getVal() {
        return val;
    }

    public String toString() {
        return "[" + this.id + ", " + this.val + "]";
    }
}

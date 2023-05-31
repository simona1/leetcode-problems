
/**
 * LeetCode problem # 1396, 'Design Underground System'
 * https://leetcode.com/problems/design-underground-system/
 */

import java.util.*;

class UndergroundSystem {
    Map<String, HashMap<String, Pair>> map;
    Map<Integer, Integer> times;
    Map<Integer, String> prev;

    public UndergroundSystem() {
        this.map = new HashMap<>();
        this.times = new HashMap<>();
        this.prev = new HashMap<>();

    }

    public void checkIn(int id, String stationName, int t) {
        times.put(id, t);
        prev.put(id, stationName);
        HashMap<String, Pair> curr = map.get(stationName);
        if (curr == null) {
            map.put(stationName, new HashMap<>());
        }

    }

    public void checkOut(int id, String stationName, int t) {
        int diff = t - times.get(id);
        HashMap<String, Pair> curr = map.get(prev.get(id));
        Pair p = curr.get(stationName);
        if (p == null) {
            curr.put(stationName, new Pair(diff, 1));
        } else {
            curr.put(stationName, new Pair(p.data + diff, p.count + 1));
        }

    }

    public double getAverageTime(String startStation, String endStation) {
        HashMap<String, Pair> start = map.get(startStation);
        if (start != null) {
            Pair curr = start.get(endStation);
            if (curr != null) {
                return (double) curr.data / (double) curr.count;
            }
        }
        return 0;
    }
}

class Pair {
    int data;
    int count;

    Pair(int data, int count) {
        this.data = data;
        this.count = count;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t); obj.checkOut(id,stationName,t); double param_3
 * = obj.getAverageTime(startStation,endStation);
 */
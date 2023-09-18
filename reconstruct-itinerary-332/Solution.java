
/**
 * LeetCode problem # 332, 'Reconstruct Itinerary'
 * https://leetcode.com/problems/reconstruct-itinerary
 */

import java.util.*;

class Solution {
    Map<String, PriorityQueue<String>> flights;
    LinkedList<String> res;

    public List<String> findItinerary(List<List<String>> tickets) {

        flights = new HashMap<>();
        res = new LinkedList<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            flights.putIfAbsent(from, new PriorityQueue<>());
            flights.get(from).add(to);
        }
        traverse("JFK");
        return res;
    }

    private void traverse(String origin) {
        PriorityQueue<String> dest = flights.get(origin);

        while (dest != null && !dest.isEmpty()) {
            traverse(dest.remove());
        }
        res.addFirst(origin);
    }
}
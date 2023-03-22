
/**
 * LeetCode problem # 1236, 'Web Crawler'
 * https://leetcode.com/problems/web-crawler
 */

/**
 * // This is the HtmlParser's API interface. // You should not implement it, or
 * speculate about its implementation interface HtmlParser { public List<String>
 * getUrls(String url) {} }
 */

import java.util.*;

class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String initial = getHostName(startUrl);

        Queue<String> q = new LinkedList<>();
        q.add(startUrl);
        Set<String> vis = new HashSet<>();
        vis.add(startUrl);

        while (!q.isEmpty()) {
            String curr = q.remove();

            for (String next : htmlParser.getUrls(curr)) {
                if (getHostName(next).equals(initial) && !vis.contains((next))) {
                    q.add(next);
                    vis.add(next);
                }
            }
        }
        List<String> res = new ArrayList<>(vis);
        return res;

    }

    private String getHostName(String url) {
        return url.split("/")[2];
    }
}


/**
 * LeetCode problem # 811, 'Subdomain Visit Count'
 * https://leetcode.com/problems/subdomain-visit-count
 */

import java.util.*;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> list = new ArrayList<>();

        for (String cp : cpdomains) {
            String[] first = cp.split(" ");
            processString(first[1], list, first[0]);
        }

        Map<String, Integer> map = new HashMap<>();
        for (String domain : list) {
            String[] parts = domain.split(" ");
            map.put(parts[1], map.getOrDefault(parts[1], 0) + Integer.parseInt(parts[0]));
        }

        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(entry.getValue());
            sb.append(" ");
            sb.append(entry.getKey());
            res.add(sb.toString());
        }
        return res;
    }

    public void processString(String str, List<String> res, String num) {
        String[] parts = str.split("\\.");

        for (int i = 0; i < parts.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(num);
            sb.append(" ");
            for (int j = i; j < parts.length; j++) {
                sb.append(parts[j]);
                if (j < parts.length - 1) {
                    sb.append(".");
                }
            }
            res.add(sb.toString());
        }
    }
}

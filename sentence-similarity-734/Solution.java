
/**
 * LeetCode problem # 734, 'Sentence Similarity'
 * https://leetcode.com/problems/sentence-similarity/
 */

import java.util.*;

class Solution {
    public boolean areSentencesSimilar(String[] s1, String[] s2, List<List<String>> pairs) {
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        int n = s1.length;
        int m = s2.length;
        if (n != m) {
            return false;
        }

        for (List<String> pair : pairs) {
            map.computeIfAbsent(pair.get(0), value -> new HashSet<String>()).add(pair.get(1));

        }
        for (int i = 0; i < n; ++i) {
            if (!(s1[i].equals(s2[i]) || found(map, s1[i], s2[i]) || found(map, s2[i], s1[i])))
                return false;
        }
        return true;
    }

    private boolean found(Map<String, Set<String>> map, String word1, String word2) {
        if (map.containsKey(word1)) {
            return map.get(word1).contains(word2);
        }
        return false;
    }
}

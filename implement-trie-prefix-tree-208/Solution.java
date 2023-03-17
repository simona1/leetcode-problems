/*
* LeetCode problem # 208, 'Implement Trie (Prefix Tree)'
* https://leetcode.com/problems/implement-trie-prefix-tree
*/

import java.util.*;

class Trie {
    public Map<Character, Trie> kids;
    public boolean isLast;

    /** Initialize your data structure here. */
    public Trie() {
        kids = new HashMap<>();
        isLast = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie curr = this;

        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);

            curr.kids.put(c, curr.kids.getOrDefault(c, new Trie()));
            curr = curr.kids.get(c);
        }
        curr.isLast = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie curr = this;

        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);

            curr = curr.kids.get(c);
            if (curr == null) {
                return false;
            }
        }
        return curr.isLast;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie curr = this;

        for (int i = 0; i < prefix.length(); ++i) {
            char c = prefix.charAt(i);

            curr = curr.kids.get(c);
            if (curr == null) {
                return false;
            }
        }
        return true;
    }
}

/*
* LeetCode problem # 211, 'Design Add and Search Words Data Structure'
* https://leetcode.com/problems/design-add-and-search-words-data-structure
*/

class WordDictionary {
    public class TrieNode {
        public TrieNode[] kids = new TrieNode[26];
        public String content = "";
    }

    private TrieNode root = new TrieNode();

    public void addWord(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (node.kids[c - 'a'] == null) {
                node.kids[c - 'a'] = new TrieNode();
            }
            node = node.kids[c - 'a'];
        }
        node.content = word;
    }

    public boolean search(String word) {
        return check(word, 0, root);
    }

    private boolean check(String word, int k, TrieNode node) {
        if (k == word.length()) {
            return !node.content.equals("");
        }

        char c = word.charAt(k);
        if (word.charAt(k) != '.') {
            return node.kids[c - 'a'] != null && check(word, k + 1, node.kids[c - 'a']);
        }

        for (int i = 0; i < node.kids.length; ++i) {
            if (node.kids[i] != null) {
                if (check(word, k + 1, node.kids[i])) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary(); obj.addWord(word); boolean param_2
 * = obj.search(word);
 */

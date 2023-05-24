
/**
 * LeetCode problem # 2689, 'Extract Kth Character From The Rope Tree'
 * https://leetcode.com/problems/extract-kth-character-from-the-rope-tree/
 */

class RopeTreeNode {
    int len;
    String val;
    RopeTreeNode left;
    RopeTreeNode right;

    RopeTreeNode() {
    }

    RopeTreeNode(String val) {
        this.len = 0;
        this.val = val;
    }

    RopeTreeNode(int len) {
        this.len = len;
        this.val = "";
    }

    RopeTreeNode(int len, TreeNode left, TreeNode right) {
        this.len = len;
        this.val = "";
        this.left = left;
        this.right = right;
    }
}

class Solution {
    StringBuilder sb;

    public char getKthCharacter(RopeTreeNode root, int k) {
        sb = new StringBuilder();
        getKthCharacterImpl(root, k);
        return sb.charAt(k - 1);
    }

    private void getKthCharacterImpl(RopeTreeNode node, int k) {
        if (sb.length() > k) {
            return;
        }
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            sb.append(node.val);
        }
        getKthCharacterImpl(node.left, k);
        getKthCharacterImpl(node.right, k);
    }
}

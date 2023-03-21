/**
 * LeetCode problem # 427, 'Construct Quad Tree'
 * https://leetcode.com/problems/construct-quad-tree
 */

// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};

class Solution {
    private boolean isLeaf(int[][] grid, int a, int b, int size) {
        if (size == 1) {
            return true;
        }
        int curr = grid[b][a];

        for (int i = b; i < b + size; ++i) {
            for (int j = a; j < a + size; ++j) {
                if (curr != grid[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private Node constructImpl(int[][] grid, int a, int b, int size) {
        Node node = new Node();
        node.isLeaf = isLeaf(grid, a, b, size);

        if (node.isLeaf) {
            node.val = grid[b][a] == 1;
            return node;
        }

        int newSize = size / 2;
        node.val = true;
        node.topLeft = constructImpl(grid, a, b, newSize);
        node.topRight = constructImpl(grid, a + newSize, b, newSize);
        node.bottomLeft = constructImpl(grid, a, b + newSize, newSize);
        node.bottomRight = constructImpl(grid, a + newSize, b + newSize, newSize);
        return node;
    }

    public Node construct(int[][] grid) {
        int n = grid.length;
        if (n == 0) {
            return null;
        }
        return constructImpl(grid, 0, 0, n);
    }
}


/**
 * LeetCode problem # 864, 'Shortest Path to Get All Keys'
 * https://leetcode.com/problems/shortest-path-to-get-all-keys/
 */

import java.util.*;

class Node {
    int row;
    int col;
    String key;

    Node(int r, int c, String key) {
        this.row = r;
        this.col = c;
        this.key = key;
    }

    public String toString() {
        return this.row + "-" + this.col + "-" + this.key;
    }
}

class Solution {
    static int[][] dirs = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

    public int shortestPathAllKeys(String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();

        Set<String> vis = new HashSet<>();

        int steps = 0;
        Queue<Node> q = new LinkedList<>();

        int keyCount = 0;

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i].charAt(j) == '@') {
                    q.add(new Node(i, j, ""));
                } else if (grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'f') {
                    ++keyCount;
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; ++i) {
                Node temp = q.remove();
                int r = temp.row;
                int c = temp.col;
                String key = temp.key;

                if (!vis.contains(temp.toString())) {
                    vis.add(temp.toString());
                } else {
                    continue;
                }

                if (key.length() == keyCount) {
                    return steps;
                }

                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    Node newNode = new Node(nr, nc, key);

                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || grid[nr].charAt(nc) == '#'
                            || vis.contains(newNode.toString())) {
                        continue;
                    }

                    char ch = grid[nr].charAt(nc);

                    if (key.indexOf(ch) == -1 && ch >= 'a' && ch <= 'f') {
                        q.add(new Node(nr, nc, key + ch));

                    } else if (ch >= 'A' && ch <= 'F' && key.indexOf(Character.toLowerCase(ch)) == -1) {
                        continue;
                    } else {
                        q.add(new Node(nr, nc, key));
                    }
                }
            }
            ++steps;
        }
        return -1;
    }
}

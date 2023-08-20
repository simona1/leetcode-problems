
/**
 * LeetCode problem # 490, 'The Maze'
 * https://leetcode.com/problems/the-maze/
 */

import java.util.*;

class Solution {
    static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        maze[start[0]][start[1]] = -1;
        int row = maze.length;
        int col = maze[0].length;

        for (int[] dir : dirs) {
            int nr = start[0] + dir[0];
            int nc = start[1] + dir[1];

            while (nr >= 0 && nr < row && nc >= 0 && nc < col && maze[nr][nc] != 1) {
                nr += dir[0];
                nc += dir[1];
            }

            int nextR = nr - dir[0];
            int nextC = nc - dir[1];
            int[] cell = new int[] { nextR, nextC };
            if (maze[nextR][nextC] != -1 && hasPath(maze, cell, destination)) {
                return true;
            }
        }
        return false;
    }
}
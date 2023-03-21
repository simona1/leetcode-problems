/**
 * LeetCode problem # 657, 'Robot Return to Origin'
 * https://leetcode.com/problems/robot-return-to-origin
 */

class Solution {
    public boolean judgeCircle(String moves) {
        int row = 0;
        int col = 0;

        for (int i = 0; i < moves.length(); ++i) {
            char move = moves.charAt(i);
            switch (move) {
            case 'U':
                --col;
                break;
            case 'D':
                ++col;
                break;
            case 'L':
                --row;
                break;
            case 'R':
                ++row;
                break;
            default:
                break;
            }
        }
        return row == 0 && col == 0;
    }
}

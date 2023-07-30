
/**
 * LeetCode problem # 1678, 'Goal Parser Interpretation'
 * https://leetcode.com/problems/goal-parser-interpretation/
 */

class Solution {
    public String interpret(String command) {
        return command.replaceAll("\\(\\)", "o").replaceAll("\\((al)\\)", "$1");
    }

    public String interpret2(String command) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < command.length(); ++i) {
            if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
                sb.append('o');
                ++i;
            } else if (command.charAt(i) == 'G') {
                sb.append('G');
            } else {
                sb.append("al");
                i += 3;
            }
        }
        return sb.toString();
    }

}
/**
 * LeetCode problem # 921, 'Minimum Add to Make Parentheses Valid'
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid
 */

function minAddToMakeValid(s: string): number {
    let res = 0;
    let balanced = 0;
    // balanced is how many '(' - how many ')'
    // valid means balanced = 0

    for (const c of s) {
        balanced += c === '(' ? 1 : -1;
        // balancing
        if (balanced === -1) {
            ++res;
            ++balanced;
        }
    }
    return res + balanced;
};
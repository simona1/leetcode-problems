
/**
 * LeetCode problem # 20, 'Valid Parentheses'
 * https://leetcode.com/problems/valid-parentheses
 */

function isValid(s: string): boolean {
    const stack: string[] = [];
    const parentheses = new Map();
    parentheses.set(']', '[');
    parentheses.set('}', '{');
    parentheses.set(')', '(');

    for (let i = 0; i < s.length; ++i) {
        const curr = s[i];
        const p = parentheses.get(curr);
        if (p) {
            if (!stack.length) {
                return false;
            }
            const last = stack.pop();
            if (last !== p) {
                return false;
            }
        } else {
            stack.push(curr);
        }
    }
    return stack.length === 0;
}


/**
 * LeetCode problem # 20, 'Valid Parentheses'
 * https://leetcode.com/problems/valid-parentheses
 */
function isValid(s: string): boolean {
    const stack: string[] = [];
    const parens = new Map([
        [']', '['],
        ['}', '{'],
        [')', '('],
    ]);

    for (const char of s) { 
        const p = parens.get(char);
        if (p) {
            if (!stack.length) {
                return false;
            }
            const last = stack.pop();
            if (last !== p) {
                return false;
            }
        } else {
            stack.push(char);
        }
    }
    return stack.length === 0;
}
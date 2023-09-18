/**
 * LeetCode problem # 150, 'Evaluate Reverse Polish Notation'
 * https://leetcode.com/problems/evaluate-reverse-polish-notation
 */

/**
 * @param {string[]} tokens
 * @return {number}
 */
const evalRPN = function (tokens) {
  const stack = [];

  for (const token of tokens) {
    if (token === "+") {
      stack.push(stack.pop() + stack.pop());
    } else if (token === "-") {
      const a = stack.pop();
      const b = stack.pop();
      stack.push(b - a);
    } else if (token === "/") {
      let a = stack.pop();
      let b = stack.pop();
      stack.push(Math.trunc(b / a));
    } else if (token === "*") {
      stack.push(stack.pop() * stack.pop());
    } else {
      stack.push(Number(token));
    }
  }
  return stack.pop();
};

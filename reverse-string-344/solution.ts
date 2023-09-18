/**
 * LeetCode problem # 344, 'Reverse String'
 * https://leetcode.com/problems/reverse-string
 */

/**
 Do not return anything, modify s in-place instead.
 */
function reverseString(s: string[]): void {
  let left = -1;
  let right = s.length;

  while (++left < --right) {
    [s[left], s[right]] = [s[right], s[left]];
  }
}

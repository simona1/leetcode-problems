/**
 * LeetCode problem # 71, 'Simplify Path'
 * https://leetcode.com/problems/simplify-path
 */

/**
 * @param {string} path
 * @return {string}
 */
function simplifyPath(path) {
  const parts = path.split("/");

  const res = [];

  for (const part of parts) {
    if (part === "." || part.length == 0) {
      continue;
    }
    if (part === "..") {
      res.pop();
    } else {
      res.push(part);
    }
  }

  let ans = "";
  for (const s of res) {
    ans += "/";
    ans += s;
  }
  return ans.length === 0 ? "/" : ans;
}

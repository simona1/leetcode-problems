/**
 * LeetCode problem # 2287, 'Rearrange Characters to Make Target String'
 * https://leetcode.com/problems/rearrange-characters-to-make-target-string/
 */

/**
 * @param {string} s
 * @param {string} target
 * @return {number}
 */
function rearrangeCharacters(s, target) {
  const map = new Map();
  for (const c of s) {
    const val = (map.get(c) ?? 0) + 1;
    map.set(c, val);
  }

  const tm = new Map();
  for (const t of target) {
    const val = (tm.get(t) ?? 0) + 1;
    tm.set(t, val);
  }

  let res = Number.MAX_SAFE_INTEGER;
  for (const c of target) {
    const val = tm.get(c);
    const available = map.get(c);
    if (!available) {
      return 0;
    }
    const copies = Math.floor(available / val);
    res = Math.min(res, copies);
  }

  return res;
}

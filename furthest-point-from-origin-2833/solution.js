/**
 * LeetCode problem # 2833, 'Furthest Point From Origin'
 * https://leetcode.com/problems/furthest-point-from-origin/
 */

/**
 * @param {string} moves
 * @return {number}
 */
function furthestDistanceFromOrigin(moves) {
  let l = 0;
  let r = 0;
  let dash = 0;

  for (let i = 0; i < moves.length; ++i) {
    if (moves[i] === "L") {
      ++l;
    } else if (moves[i] === "R") {
      ++r;
    } else {
      ++dash;
    }
  }
  return Math.max(l, r) + dash - Math.min(l, r);
}

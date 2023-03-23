/**
 * LeetCode problem # 744, 'Find Smallest Letter Greater Than Target'
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target
 */

/**
 * @param {character[]} letters
 * @param {character} target
 * @return {character}
 */
function nextGreatestLetter(letters, target) {
  const index = findLastInsertIndex(letters, target);
  return index === letters.length ? letters[0] : letters[index];
}

function findLastInsertIndex(arr, value) {
  let low = -1;
  let high = arr.length;

  // Bounds: arr[low] <= value < arr[high]

  while (low + 1 !== high) {
    const mid = low + ((high - low) >> 1);
    if (arr[mid] <= value) {
      low = mid;
    } else {
      high = mid;
    }
  }
  return high;
}

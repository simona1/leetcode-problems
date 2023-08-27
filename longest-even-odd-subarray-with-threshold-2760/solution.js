/**
 * LeetCode problem # 2760, 'Longest Even Odd Subarray With Threshold'
 * https://leetcode.com/problems/longest-even-odd-subarray-with-threshold/
 */

/**
 * @param {number[]} nums
 * @param {number} threshold
 * @return {number}
 */
function longestAlternatingSubarray(nums, threshold) {
  let res = 0;
  let count = 0;

  for (const num of nums) {
    if (num > threshold) {
      count = 0;
      continue;
    }
    if (num % 2 === count % 2) {
      ++count;
    } else {
      count = num % 2 === 0 ? 1 : 0;
    }
    res = Math.max(res, count);
  }
  return res;
}

/*
[3, 2, 4, 5], 5

- iterate over nums 
- if num is larger than threshold we should reset count to 0 and continue
- otherwise check: 
    if num is even when count is even and num is odd when count is odd -> increase count 
    because we want the numbers to alternate 
    else if the count parity didn't match current number parity we need to reset the count to 1 if current number is even and to 0 if it's odd

num = 3, count = 0, parity doesn't match -> count = 0

num = 2, count = 0, parity matches, count -> 1

num = 5, count 1, parity matches, count -> 2 

num = 4, count = 2, parity matches, count -> 3
set res to maximum of res and count

return res which at this point is 3
*/

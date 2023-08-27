/**
 * LeetCode problem # 2748, 'Number of Beautiful Pairs'
 * https://leetcode.com/problems/number-of-beautiful-pairs/
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
function gcd(a, b) {
  if (b === 0) {
    return a;
  }
  return gcd(b, a % b);
}

function isCoPrime(a, b) {
  return gcd(a, b) === 1;
}

function countBeautifulPairs(nums) {
  const map = new Map();
  let res = 0;

  for (const num of nums) {
    const last = num % 10;
    const first = Math.floor(num / 10 ** Math.floor(Math.log10(num)));

    for (const [digit, count] of map) {
      if (isCoPrime(digit, last)) {
        res += count;
      }
    }
    map.set(first, (map.get(first) ?? 0) + 1);
  }

  return res;
}

/*

for gcd: 
- guard against division by 0
- recursively call gcd with num2, num1 mod num2 

for coPrime - gcd must be 1

for getting first digit in constant time - get it with the log formula
need to floor the division (!)
last digit is easy to get in constant time by doing mod 10

add to map for O(n) solution

*/

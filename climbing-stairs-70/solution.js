/**
 * LeetCode problem # 70, 'Climbing Stairs'
 * https://leetcode.com/problems/climbing-stairs
 */

/**
 * @param {number} n
 * @return {number}
 */
function climbStairs(n) {
  const sqrt5 = Math.sqrt(5);
  const phi = (1 + sqrt5) / 2;
  const psi = (1 - sqrt5) / 2;

  return Math.round((Math.pow(phi, n + 1) - Math.pow(psi, n + 1)) / sqrt5);
}

/*

Math formula:
φ^(n+1) - (-φ)^(n+1)) / √5 

Calculates the nth Fibonacci number using the golden ratio (φ)

simpler version from Miorel (saving here)
function climbStairs(n: number): number {
  // https://en.wikipedia.org/wiki/Fibonacci_sequence#Computation_by_rounding
  const phi = (1 + Math.sqrt(5)) / 2;
  return Math.round(phi ** (n + 1) / Math.sqrt(5));
}


*/

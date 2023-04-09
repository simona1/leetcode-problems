/**
 * LeetCode problem # 2614, 'Prime In Diagonal'
 * https://leetcode.com/problems/prime-in-diagonal
 */

/**
 * @param {number[][]} nums
 * @return {number}
 */
function diagonalPrime(grid) {
  const n = grid.length;
  let largestPrime = 0;

  for (let i = 0; i < n; ++i) {
    for (let j = 0; j < n; ++j) {
      if (isOnDiagonal(grid, i, j) && isPrime(grid[i][j])) {
        largestPrime = Math.max(largestPrime, grid[i][j]);
      }
    }
  }
  return largestPrime;
}

function isOnDiagonal(grid, i, j) {
  const n = grid.length;
  return i === j || i + j === n - 1;
}

function isPrime(n) {
  if (n <= 1) {
    return false;
  }
  for (let i = 2; i * i <= n; ++i) {
    if (n % i === 0) {
      return false;
    }
  }
  return true;
}

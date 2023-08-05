/**
 * LeetCode problem # 2806, 'Account Balance After Rounded Purchase'
 * https://leetcode.com/problems/account-balance-after-rounded-purchase/
 */

/**
 * @param {number} purchaseAmount
 * @return {number}
 */
function accountBalanceAfterPurchase(purchaseAmount) {
  if (purchaseAmount % 10 === 0) {
    return 100 - purchaseAmount;
  }

  if (purchaseAmount % 10 >= 5) {
    let rem = purchaseAmount % 10;
    purchaseAmount += 10 - rem;
  } else {
    purchaseAmount = Math.floor(purchaseAmount / 10) * 10;
  }
  return 100 - purchaseAmount;
}

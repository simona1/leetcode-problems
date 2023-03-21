
/**
 * LeetCode problem # 67, 'Add Binary'
 * https://leetcode.com/problems/add-binary/
 */

import java.math.BigInteger;

class Solution {
  public String addBinary(String a, String b) {
    BigInteger x = new BigInteger(a, 2);
    BigInteger y = new BigInteger(b, 2);
    BigInteger zero = new BigInteger("0", 2);
    BigInteger carry;
    BigInteger res;

    while (y.compareTo(zero) != 0) {
      res = x.xor(y);
      carry = x.and(y).shiftLeft(1);
      x = res;
      y = carry;
    }
    return x.toString(2);
  }
}

/**
 * LeetCode problem # 1009, 'Complement of Base 10 Integer'
 * https://leetcode.com/problems/complement-of-base-10-integer/
 */

class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }

        // Count the number of significant bits (excluding leading zeros) in n
        int numBits = 0;
        int temp = n;
        while (temp > 0) {
            temp >>= 1;
            numBits++;
        }

        // Bitmask with all bits set from the most significant bit position
        int bitmask = (1 << numBits) - 1;

        // XOR with the bitmask to get the complement
        return n ^ bitmask;
    }
}
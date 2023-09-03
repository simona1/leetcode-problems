
/**
 * LeetCode problem # 9, 'Palindrome Number'
 * https://leetcode.com/problems/palindrome-number/
 */
function isPalindrome(x: number): boolean {
    if (x < 0) {
        return false;
    }
    let i = 0;
    let j = getDigitCount(x) - 1;
    while (i < j) {
        if (getNthFromRight(x, i) !== getNthFromRight(x, j)) {
            return false;
        }
        ++i;
        --j;
    }
    return true;
};

const getDigitCount = (num: number): number => {
    if (num === 0) {
        return 1;
    }
    return 1 + Math.floor(Math.log10(num));
}

const getNthFromRight = (x: number, num: number): number => {
  return Math.floor((x % 10 ** (num + 1)) / 10 ** num);
}

/*

num = 1, x = 12321
12321 % (10 ** (1 + 1)) = 21
21 / 10 = 2.1 floors to 2

num = 2, x = 12321
12321 % (10 ** (2 + 1)) = 12321 % 1000 = 321
321 % 100 = 3.21 -> floors to 3

*/
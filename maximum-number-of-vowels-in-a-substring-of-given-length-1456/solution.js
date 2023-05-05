/**
 * LeetCode problem # 1456, 'Maximum Number of Vowels in a Substring of Given Length'
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 */

 /**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
function maxVowels(s, k) {
    const set = new Set();
    for (const vowel of "aeiou") {
        set.add(vowel);
    }
    
    let res = 0;
    let count = 0;

    for (let i = 0; i < s.length; ++i) {
        if (i >= k) {
            if (set.has(s[i - k])) {
                --count;
            }
        }
        
        if (set.has(s[i])) {
            ++count;
            res = Math.max(res, count);
            if (res === k) {
                return k;
            }
        }
    }
    return res;
}

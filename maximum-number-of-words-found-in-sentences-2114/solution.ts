/**
 * LeetCode problem # 2114, 'Maximum Number of Words Found in Sentences'
 * https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/
 */

function mostWordsFound(sentences: string[]): number {
    let res = 0;
    function countBlanks(s) {
        let res = 0;
        for (const char of s) {
            if (char === ' ') {
                ++res;
            }
        }
        return res;
    }

    for (const s of sentences) {
        res = Math.max(res, countBlanks(s) + 1);
    }

    return res;
};

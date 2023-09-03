/**
 * LeetCode problem # 2648, 'Generate Fibonacci Sequence'
 * https://leetcode.com/problems/generate-fibonacci-sequence
 */

/**
 * @return {Generator<number>}
 */
function* fibGenerator(): Generator<number, any, number> {
    let a = 1;
    let b = 0;

    while (true) {
        [a, b] = [b, a + b];
        yield a;
        
    }
};

//...13, -8, 5, -3, 2, -1, 1, 0, 1, 1, 2, 3, 5, 8, 13...


/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */

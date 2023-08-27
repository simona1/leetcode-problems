/**
 * LeetCode problem # 2634, 'Filter Elements from Array'
 * https://leetcode.com/problems/filter-elements-from-array/
 */

/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
function filter1(arr: number[], fn: (n: number, i: number) => any): number[] {
    
    return arr.reduce((acc: number[], num, i) => {
        fn(num, i) && acc.push(num);
        return acc;
    }, []);

    // this one-liner version copies the array on every iteration  
    // return arr.reduce((acc, num, i) => fn(num, i) ? [...acc, num] : acc, [])

}
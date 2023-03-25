/**
 * LeetCode problem # 2597, 'The Number of Beautiful Subsets'
 * https://leetcode.com/problems/the-number-of-beautiful-subsets
 */

function beautifulSubsets(nums: number[], k: number): number {
  let count = 0;
  const st: number[] = [];
  const map: Record<number, number> = {};
  printAllSubsets([1, 2, 3, 4, 5]);

  const traverse = (index: number) => {
    if (index === nums.length) {
      ++count;
      return;
    }

    traverse(index + 1);

    const curr = nums[index];
    if (map[curr + k] || map[curr - k]) {
      return;
    }

    st.push(curr);
    map[curr] = (map[curr] ?? 0) + 1;

    traverse(index + 1);
    st.pop();

    --map[curr];
  };

  traverse(0);

  return count - 1;
}

function printAllSubsets(nums: number[]): void {
  const st: number[] = [];

  const traverse = (index: number) => {
    if (index === nums.length) {
      console.log(st);
      return;
    }

    st.push(nums[index]);
    traverse(index + 1);
    st.pop();

    traverse(index + 1);
  };

  traverse(0);
}

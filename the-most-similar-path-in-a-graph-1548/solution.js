/**
 * LeetCode problem # 1548, 'The Most Similar Path in a Graph'
 * https://leetcode.com/problems/the-most-similar-path-in-a-graph/
 */

/**
 * @param {number} n
 * @param {number[][]} roads
 * @param {string[]} names
 * @param {string[]} targetPath
 * @return {number[]}
 */
var mostSimilar = function (n, roads, names, targetPath) {
  const adjList = Array.from(
    {
      length: n,
    },
    (x) => []
  );

  for (const [s, t] of roads) {
    adjList[s].push(t);
    adjList[t].push(s);
  }

  const visited = Array.from(
    {
      length: n,
    },
    (x) => new Array(targetPath.length).fill(-1)
  );

  const nextChoiceForMin = Array.from(
    {
      length: n,
    },
    (x) => new Array(targetPath.length)
  );

  const DFS = (node, index) => {
    if (visited[node][index] !== -1) return visited[node][index];

    let edits = names[node] !== targetPath[index] ? 1 : 0;

    // at the end
    if (index === targetPath.length - 1) {
      return edits;
    }

    let minAddEdits = Number.POSITIVE_INFINITY;

    for (const nb of adjList[node]) {
      const nextDist = DFS(nb, index + 1);

      if (nextDist < minAddEdits) {
        minAddEdits = nextDist;
        nextChoiceForMin[node][index] = nb;
      }
    }

    edits += minAddEdits;

    visited[node][index] = edits;
    return edits;
  };

  let minTotalDist = Number.POSITIVE_INFINITY;
  let start = 0;

  for (let i = 0; i < n; i++) {
    const cost = DFS(i, 0);
    if (cost < minTotalDist) {
      minTotalDist = cost;
      start = i;
    }
  }

  const result = [];

  while (result.length < targetPath.length) {
    result.push(start);
    start = nextChoiceForMin[start][result.length - 1];
  }

  return result;
};

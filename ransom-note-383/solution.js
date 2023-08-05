/**
 * LeetCode problem # 383, 'Ransom Note'
 * https://leetcode.com/problems/ransom-note
 */

/**
 * @param {string} ransomNote
 * @param {string} magazine
 * @return {boolean}
 */
function canConstruct(ransomNote, magazine) {
  const noteFreq = new Map();
  const magFreq = new Map();

  ransomNote.split("").forEach((r) => {
    noteFreq.set(r, (noteFreq.get(r) ?? 0) + 1);
  });
  magazine.split("").forEach((m) => {
    magFreq.set(m, (magFreq.get(m) ?? 0) + 1);
  });

  for (const [ch, freq] of noteFreq) {
    if (!magFreq.has(ch) || freq > magFreq.get(ch)) {
      return false;
    }
  }
  return true;
}

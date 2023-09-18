/**
 * LeetCode problem # 648, 'Replace Words'
 * https://leetcode.com/problems/replace-words
 */


class TrieNode {
  private isEnd: boolean = false;
  private children: Record<string, TrieNode> = {};

  add(s: string) {
    this.addImpl(s, 0);
  }

  private addImpl(s: string, index: number) {
    if (index === s.length) {
      this.isEnd = true;
      return;
    }

    const c = s[index];
    const child = this.children[c] ?? new TrieNode();
    this.children[c] = child;
    child.addImpl(s, index + 1);
  }

  getPrefix(s: string): string | null {
    return this.getPrefixImpl(s, 0, "");
  }

  private getPrefixImpl(s: string, index: number, prefix: string): string | null {
    if (this.isEnd) {
      return prefix;
    }

    if (index === s.length) {
      return null;
    }

    const c = s[index];
    const child = this.children[c];
    return child ? child.getPrefixImpl(s, index + 1, prefix + c) : null;
  }
}

function replaceWords(dict: string[], sentence: string): string {
  const trie = new TrieNode();
  for (const word of dict) {
    trie.add(word);
  }

  return sentence.split(" ")
    .map(word => trie.getPrefix(word) ?? word)
    .join(" ");
}

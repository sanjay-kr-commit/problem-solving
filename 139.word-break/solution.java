import java.util.*;

// @leet start
import java.util.List;

class Solution {

  public boolean wordBreak(String s, List<String> wordDict) {
    TrieNode root = new TrieNode();
    for (String word : wordDict)
      insert(root, word, 0, word.length());
    boolean[] dp = new boolean[s.length()];
    for (int index = 0; index < s.length(); index++) {
      if (index == 0 || dp[index - 1]) {
        TrieNode node = root;
        for (int j = index; j < s.length(); j++) {
          int addr = s.charAt(j) - 'a';
          if (node.child[addr] == null)
            break;
          node = node.child[addr];
          if (node.isEnd)
            dp[j] = true;
        }
      }
    }
    return dp[s.length() - 1];
  }

  void insert(TrieNode node, String string, int index, int len) {
    if (node == null)
      return;
    if (index == len) {
      node.isEnd = true;
      return;
    }
    int addr = string.charAt(index) - 'a';
    if (node.child[addr] == null)
      node.child[addr] = new TrieNode();
    insert(node.child[addr], string, index + 1, len);
  }

  class TrieNode {
    TrieNode[] child = new TrieNode[26];
    boolean isEnd = false;
  }

}
// @leet end

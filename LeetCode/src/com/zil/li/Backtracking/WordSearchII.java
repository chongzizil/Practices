package com.zil.li.Backtracking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by youlongli on 3/2/15.
 *
 * http://www.lintcode.com/en/problem/word-search-ii/#
 *
 * Ref: http://www.toptal.com/java/the-trie-a-neglected-data-structure
 *
 * Idea: Use trie tree.
 */
public class WordSearchII {
  private class TrieNode {
    public int numChildren = 0;
    public boolean isWord = false;
    private TrieNode[] children = new TrieNode[26];

    public TrieNode() {
    }

    public TrieNode(Collection<String> words) {
      for (String word : words) {
        add(word);
      }
    }

    public boolean add(String s) {
      char first = s.charAt(0);
      int index = first - 'a';
      TrieNode child = children[index];
      if (child == null) {
        child = new TrieNode();
        children[index] = child;
        numChildren++;
      }
      if (s.length() == 1) {
        if (child.isWord) {
          return false;
        }
        child.isWord = true;
        return true;
      } else {
        return child.add(s.substring(1));
      }
    }

    public TrieNode getNextNode(char c) {
      int index = c - 'a';
      return children[index];
    }

    public TrieNode getNode(String s) {
      TrieNode node = this;
      for (int i = 0; i < s.length(); i++) {
        int index = s.charAt(i) - 1;
        TrieNode child = node.children[index];
        if (child == null) {
          return null;
        }
        node = child;
      }
      return node;
    }

    public boolean contains(String s) {
      TrieNode node = getNode(s);
      return node != null && node.isWord;
    }

    public boolean isPrefix(String s) {
      TrieNode node = getNode(s);
      return node != null && node.numChildren > 0;
    }
  }

  public List<String> wordSearchII(char[][] board, List<String> words) {
    TrieNode trieDict = new TrieNode(words);
    List<String> res = new ArrayList<String>();
    List<Character> chars = new ArrayList<Character>();

    int m = board.length;
    int n = board[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        helper(res, chars, board, trieDict, i, j);
      }
    }

    return res;
  }

  private void helper(List<String> res, List<Character> chars, char[][] board, TrieNode node, int i, int j) {
    int m = board.length;
    int n = board[0].length;

    if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '#') {
      return;
    }

    char c = board[i][j];

    TrieNode child = node.getNextNode(c);
    if (child == null) {
      return;
    }

    chars.add(c);
    board[i][j] = '#';

    if (child.isWord) {
      String str = getStr(chars);
      if (!res.contains(str)) {
        res.add(str);
      }
    }

    helper(res, chars, board, child, i + 1, j);
    helper(res, chars, board, child, i - 1, j);
    helper(res, chars, board, child, i, j + 1);
    helper(res, chars, board, child, i, j - 1);
    board[i][j] = chars.get(chars.size() - 1);
    chars.remove(chars.size() - 1);
  }

  private String getStr(List<Character> chars) {
    StringBuilder sb = new StringBuilder();
    for (char c : chars) {
      sb.append(c);
    }
    return sb.toString();
  }
}

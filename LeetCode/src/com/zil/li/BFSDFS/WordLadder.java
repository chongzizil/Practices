package com.zil.li.BFSDFS;

import java.util.*;

/**
 * Created by youlongli on 3/6/15.
 * <p>
 * https://oj.leetcode.com/problems/word-ladder/
 */
public class WordLadder {
  public int ladderLength(String start, String end, Set<String> dict) {
    Queue<String> queue = new LinkedList<>();
    Set<String> found = new HashSet<>();
    int len = 1;

    queue.offer(start);

    while (!queue.isEmpty()) {
      len++;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String word = queue.poll();
        List<String> nextWordList = nextWords(word, dict);

        for (String nextWord : nextWordList) {
          if (nextWord.equals(end)) {
            return len;
          }

          if (found.contains(nextWord)) {
            continue;
          }

          queue.offer(nextWord);
          found.add(nextWord);
        }
      }
    }

    return 0;
  }

  private List<String> nextWords(String word, Set<String> dict) {
    List<String> nextWordList = new ArrayList<>();
    for (int i = 0; i < word.length(); i++) {
      for (char c = 'a'; c <= 'z'; c++) {
        String next = word.substring(0, i) + c + word.substring(i + 1);
        if (dict.contains(next)) {
          nextWordList.add(next);
        }
      }
    }
    return nextWordList;
  }
}

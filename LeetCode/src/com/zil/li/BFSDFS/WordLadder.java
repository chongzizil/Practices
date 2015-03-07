package com.zil.li.BFSDFS;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by youlongli on 3/6/15.
 *
 * https://oj.leetcode.com/problems/word-ladder/
 */
public class WordLadder {
  public int ladderLength(String start, String end, Set<String> dict) {
    if (start == null || end == null || dict == null) {
      return 0;
    }

    Set<String> visited = new HashSet<String>(); // Remember all visit word
    Deque<String> queue = new ArrayDeque<String>(); // For BFS
    int len = 1; // Initial length is 1

    visited.add(start);
    queue.addLast(start);

    while (!queue.isEmpty()) {
      len++; // Update length first
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        String str = queue.pollFirst();

        for (int j = 0; j < str.length(); j++) {
          StringBuilder sb = new StringBuilder(str); // Use StringBuilder to manipulate each character
          for (char c = 'a'; c <= 'z'; c++) { // Try possible every character
            sb.setCharAt(j, c);
            String tmp = sb.toString();

            if (tmp.equals(end)) { // Find the path!
              return len;
            }

            if (visited.contains(tmp) || !dict.contains(tmp)) { // Make sure the word exists in the dict and is not visited
              continue;
            }

            queue.addLast(sb.toString());
            visited.add(tmp);
          }
        }
      }
    }

    return 0;
  }
}

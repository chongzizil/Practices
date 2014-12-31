package com.zil.li.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by youlongli on 12/30/14.
 *
 * Some details:
 * 1. Is it case sensitive?
 * 2. Is it possible a empty string, and will it be considered a palindrome?
 * 3. What character will be considered valid. Letter, Digit, etc...
 */
public class ValidPalindrome {
  /**
   * Queue
   * Time complexity: O(n)
   * Space complexity: O(n)
   * Runtime: 436 ms
   */
  public boolean solutionA(String s) {
    Deque<Character> queue = new ArrayDeque<>();
    s = s.toLowerCase();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isLetterOrDigit(c)) {
        queue.addLast(c);
      }
    }

    // If there's at most 1 left, it's a palindrome...
    while (queue.size() > 1) {
      char head = queue.pollFirst();
      char tail = queue.pollLast();
      if (head != tail) {
        return false;
      }
    }

    return true;
  }

  /**
   * Two pointers
   * Time complexity: O(n)
   * Space complexity: O(1)
   * Runtime: 464 ms
   */
  public boolean solutionB(String s) {
    int low = 0;
    int high = s.length() - 1;
    s = s.toLowerCase();

    while (low < high) {
      while (low < high && !Character.isLetterOrDigit(s.charAt(low))) {
        low++;
      }
      while (low < high && !Character.isLetterOrDigit(s.charAt(high))) {
        high--;
      }

      if (s.charAt(low) != s.charAt(high)) {
        return false;
      }

      low++;high--;
    }

    return true;
  }
}

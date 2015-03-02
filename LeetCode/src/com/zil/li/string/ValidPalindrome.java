package com.zil.li.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by youlongli on 12/30/14.
 *
 * https://oj.leetcode.com/problems/valid-palindrome/
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
    int l = 0;
    int r = s.length() - 1;
    // Note: Take care of the cases
    s = s.toLowerCase();

    while (l < r) {
      while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
        l++;
      }
      while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
        r--;
      }

      if (s.charAt(l) != s.charAt(r)) {
        return false;
      }
      // Do not forget to move the pointers
      l++;
      r--;
    }

    return true;
  }
}

package com.zil.li.string;

/**
 * Created by youlongli on 1/21/15.
 *
 * https://oj.leetcode.com/problems/valid-number/
 */
public class ValidNumber {
  /**
   * Time complexity: O(n)
   * Space complexity: O(1)
   * Runtime: 224 ms
   */
  public boolean solutionA(String s) {
    int i = 0;
    int n = s.length();
    boolean isNumber = false;

    // Skip leading spaces
    while(i < n && s.charAt(i) == ' ') i++;
    // Check unary operator
    if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
    // Check numbers
    while(i < n && Character.isDigit(s.charAt(i))) {
      isNumber = true;
      i++;
    }
    if (i < n && s.charAt(i) == '.') {
      // .1 is considered valid, otherwise check isNumber is necessary.
      i++;
      while(i < n && Character.isDigit(s.charAt(i))) {
        isNumber = true;
        i++;
      }
    }

    if (isNumber && i < n && s.charAt(i) == 'e') {
      // Need a valid integer
      isNumber = false;
      i++;
      // Check unary operator
      if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
      // Check integer after exp
      while(i < n && Character.isDigit(s.charAt(i))) {
        isNumber = true;
        i++;
      }
    }

    // Skip the trailing spaces
    while(i < n && s.charAt(i) == ' ') i++;

    return isNumber && i == s.length();
  }
}

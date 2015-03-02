package com.zil.li.math;

/**
 * Created by youlongli on 3/1/15.
 *
 * https://oj.leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {
  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false; // Negative number is not a palindrome
    }

    int div = 1; // Used to chop off the most significant digit
    while (x / div >= 10) {
      div = div * 10;
    }

    while (x != 0) {
      int l = x / div;
      int r = x % 10;
      if (l != r) {
        return false;
      }
      x = (x % div) / 10;
      div = div / 100;
    }

    return true;
  }
}

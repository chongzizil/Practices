package com.zil.li.math;

/**
 * Created by youlongli on 2/9/15.
 *
 * https://oj.leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {
  private static final int MAX = Integer.MAX_VALUE;
  private static final int MIN = Integer.MIN_VALUE;

  /**
   * Runtime: 246 ms
   */
  public int reverse(int x) {
    int res = 0;

    while (x != 0) {
      int digit = x % 10;

      if (x > 0) { // Positive, check overflow
        if (res > MAX / 10 || (res == MAX / 10 && digit > MAX % 10)) {
          return 0;
        }
      } else { // Negative, check underflow
        if (res < MIN / 10 || (res == MIN / 10 && digit < MIN % 10)) {
          return 0;
        }
      }

      x /= 10;
      res = res * 10 + digit;
    }

    return res;
  }
}

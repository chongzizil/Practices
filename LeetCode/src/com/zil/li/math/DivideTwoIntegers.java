package com.zil.li.math;

/**
 * Created by youlongli on 2/2/15.
 *
 * https://oj.leetcode.com/problems/divide-two-integers/
 */
public class DivideTwoIntegers {
  /**
   * The idea is to use << as *...
   * Runtime: 239 ms
   */
  public int divide(int dividend, int divisor) {
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }

    int sign = 1;
    if (dividend < 0 ^ divisor < 0) {
      sign = -1;
    }

    int res = 0;
    long a = Math.abs((long)dividend);
    long b = Math.abs((long)divisor);

    while (a >= b) {
      int shift = 1;
      while (a >= (b << shift)) {
        shift++;
      }

      res += 1 << (shift - 1);
      a -= b << (shift - 1);
    }

    return res * sign;
  }
}

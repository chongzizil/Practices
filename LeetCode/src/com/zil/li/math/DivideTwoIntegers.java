package com.zil.li.math;

/**
 * Created by youlongli on 2/2/15.
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

    int res = 0;
    boolean isPositive = true;
    long a = Math.abs((long)dividend);
    long b = Math.abs((long)divisor);

    if (dividend >= 0 ^ divisor >= 0) {
      isPositive = false;
    }

    while (a >= b) {
      int shift = 1;
      while ((b << shift) <= a) {
        shift++;
      }

      a -= b << (shift - 1);
      res += 1 << (shift - 1);
    }

    return isPositive ? res : -res;
  }
}

package com.zil.li.math;

/**
 * Created by youlongli on 2/9/15.
 */
public class ReverseInteger {
  private static final int MAX = Integer.MAX_VALUE;
  private static final int MIN = Integer.MIN_VALUE;

  /**
   * Runtime: 246 ms
   */
  public int reverse(int x) {
    boolean isPositive = true;
    int res = 0;

    if (x < 0) {
      isPositive = false;
    }

    while (x != 0) {
      int digit = x % 10;

      if (isPositive) {
        if (res > MAX / 10 || (res == MAX / 10 && digit > MAX % 10)) {
          return 0;
        }
      } else {
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

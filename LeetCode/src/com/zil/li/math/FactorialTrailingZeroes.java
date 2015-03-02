package com.zil.li.math;

/**
 * Created by youlongli on 3/2/15.
 *
 * https://oj.leetcode.com/problems/factorial-trailing-zeroes/
 *
 * Idea: https://oj.leetcode.com/discuss/20691/my-explanation-of-the-log-n-solution
 */
public class FactorialTrailingZeroes {
  public int trailingZeroes(int n) {
    int res = 0;
    int pow = 1;
    int f = (int) (n / Math.pow(5, pow++));

    while (f > 0) {
      res += f;
      f = (int) (n / Math.pow(5, pow++));
    }

    return res;
  }
}

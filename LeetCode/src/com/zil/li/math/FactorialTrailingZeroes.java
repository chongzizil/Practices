package com.zil.li.math;

/**
 * Created by youlongli on 3/2/15.
 *
 * https://oj.leetcode.com/problems/factorial-trailing-zeroes/
 *
 * Idea: https://oj.leetcode.com/discuss/20691/my-explanation-of-the-log-n-solution
 *
 * Inorder to have a zero, we need 2 * 5, since for n!, the number of 2s must be larger than the number of 5s, the
 * number of 0s will be the number of 5s.
 *
 * i.g. 25! have 25, 20, 15 10, 5. Notice that 25 has two 5s.
 */
public class FactorialTrailingZeroes {
  public int trailingZeroes(int n) {
    int res = 0;
    int pow = 1;
    // Check how many Math.pow(5, pow) we have.
    int f = (int) (n / Math.pow(5, pow++));

    while (f > 0) {
      res += f;
      f = (int) (n / Math.pow(5, pow++));
    }

    return res;
  }

  // Concise version, though slight performance hit (Double calculation for pow)
  public int trailingZeroesB(int n) {
    int res = 0;
    int pow = 1;

    while (((int) (n / Math.pow(5, pow))) > 0) {
      res += (int) (n / Math.pow(5, pow++));
    }

    return res;
  }
}

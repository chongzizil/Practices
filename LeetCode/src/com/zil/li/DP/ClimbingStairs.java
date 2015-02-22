package com.zil.li.DP;

/**
 * Created by youlongli on 2/22/15.
 *
 * https://oj.leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {
  /**
   * We only need to use three variable to store the states...
   */
  public int solutionA(int n) {
    if (n <= 1) {
      return n;
    }

    int prev = 1, prevPrev = 1;
    int now = 0;
    for (int i = 2; i <= n; i++) {
      now = prev + prevPrev;
      prevPrev = prev;
      prev = now;

    }

    return now;
  }

  public int solutionB(int n) {
    if (n <= 1) {
      return n;
    }

    int[] f = new int[n];
    f[0] = 1;
    f[1] = 2;
    for (int i = 2; i < n; i++) {
      f[i] = f[i - 1] + f[i - 2];
    }

    return f[n - 1];
  }
}

package com.zil.li.math;

/**
 * Created by youlongli on 3/5/15.
 * <p>
 * https://oj.leetcode.com/problems/powx-n/
 */
public class Pow {
  public double pow(double x, int n) {
    boolean isNPositive = true;

    if (n == 0) {
      return 1;
    } else if (n == 1) {
      return x;
    } else if (n < 0) {
      isNPositive = false;
      n = -n;
    }

    int i = n / 2;
    int j = n - i * 2;
    double l = pow(x, i);
    double r = pow(x, j);
    double res = l * l * r;

    return isNPositive ? res : 1 / res;
  }
}

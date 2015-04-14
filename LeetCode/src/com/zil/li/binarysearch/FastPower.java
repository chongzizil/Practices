package com.zil.li.binarysearch;

/**
 * Created by youlongli on 4/13/15.
 *
 * http://lintcode.com/en/problem/fast-power/
 */
public class FastPower {
  public int fastPower(int a, int b, int n) {
    // write your code here
    boolean isPositive = true;
    if (n < 0) {
      n = -n;
      isPositive = false;
    } else if (n == 0) {
      return 1 % b;
    } else if (n == 1) {
      return a % b;
    }

    int i = n / 2;
    int j = n - 2 * i;

    // Use long to avoid overflow for pow(b, 2).
    long l = fastPower(a, b, i);
    long r = fastPower(a, b, j);
    long res = ((((l % b) * (l % b)) % b) * (r % b)) % b;
    int tmp = (int) res;
    return isPositive ? tmp : 1 / tmp;
  }
}

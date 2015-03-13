package com.zil.li.bit;

/**
 * Created by youlongli on 3/10/15.
 *
 * https://leetcode.com/problems/number-of-1-bits/
 */
public class NumberOf1Bits {
  // you need to treat n as an unsigned value
  public int solutionA(int n) {
    int res = 0;
    for (int i = 0; i < 32; i++) {
      res += ((n >> i) & 1) == 1 ? 1 : 0;
    }
    return res;
  }

  public int solutionB(int n) {
    int res = 0;

    while(n != 0) {
      n &= n - 1;
      ++ res;
    }

    return res;
  }
}

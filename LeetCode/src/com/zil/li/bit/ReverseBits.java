package com.zil.li.bit;

/**
 * Created by youlongli on 3/8/15.
 *
 * https://leetcode.com/problems/reverse-bits/submissions/
 *
 * Idea: Divide int to 4 bytes and use map to cache
 */
public class ReverseBits {
  // you need treat n as an unsigned value
  public int solutionA(int n) {
    int res = 0;
    for (int i = 0; i < 32; i++) {
      res |= ((n >> i) & 1) << (31 - i);
    }
    return res;
  }

  // you need treat n as an unsigned value
  public int SolutionB(int n) {
    for (int i = 0, j = 31; i < j; i++, j--) {
      n = swap(n, i, j);
    }
    return n;
  }

  private int swap(int n, int i, int j) {
    int a = (n >> i) & 1;
    int b = (n >> j) & 1;
    if ((a ^ b) == 1) {
      n ^= (1 << i | 1 << j);
    }
    return n;
  }
}

package com.zil.li.bit;

/**
 * Created by youlongli on 3/1/15.
 *
 * https://oj.leetcode.com/problems/single-number/
 */
public class SingleNumber {
  public int singleNumber(int[] A) {
    int res = 0;

    for (int num : A) {
      res = res ^ num;
    }

    return res;
  }
}

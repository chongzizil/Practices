package com.zil.li.array;

/**
 * Created by youlongli on 3/7/15.
 *
 * https://oj.leetcode.com/problems/majority-element/
 */
public class MajorityElement {
  public int majorityElement(int[] num) {
    int count = 0;
    int res = 0;

    for (int i = 0; i < num.length; i++) {
      if (count == 0) {
        count++;
        res = num[i];
      } else if (num[i] != res) {
        count--;
      } else {
        count++;
      }
    }

    return res;
  }
}

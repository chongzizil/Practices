package com.zil.li.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 3/6/15.
 *
 * https://oj.leetcode.com/problems/gray-code/
 *
 * Ref: http://www.cnblogs.com/yuzhangcmu/p/4121804.html
 * http://zh.wikipedia.org/wiki/%E6%A0%BC%E9%9B%B7%E7%A0%81
 */
public class GrayCode {
  public List<Integer> grayCode(int n) {
    List<Integer> res = new ArrayList<Integer>();

    // Base case
    if (n == 0) {
      res.add(0);
      return res;
    }

    // Get the upper part
    res = grayCode(n - 1);

    // Construct the lower part, which is mirrored of the upper part where the most significant digit is 1 instead of 0.
    for (int i = res.size() - 1; i >= 0; i--) {
      int num = res.get(i);
      res.add(num | (1 << (n - 1)));
    }

    return res;
  }
}

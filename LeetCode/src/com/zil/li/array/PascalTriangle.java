package com.zil.li.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 3/12/15.
 *
 * https://leetcode.com/problems/pascals-triangle/
 */
public class PascalTriangle {
  /**
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public List<List<Integer>> generateA(int numRows) {
    List<List<Integer>> res = new ArrayList<>();

    if (numRows == 0) {
      return res;
    }

    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j <= i; j++) {
        if (res.size() < i + 1) {
          List<Integer> list = new ArrayList<>();
          res.add(list);
        }
        if (j == 0 || j == i) {
          res.get(i).add(1);
        } else {
          res.get(i).add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
        }
      }
    }

    return res;
  }

  /**
   * Time complexity: O(n)
   * Space complexity: O(1) (Does not count res...)
   */
  public List<List<Integer>> generateB(int numRows) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> prev = new ArrayList<Integer>();

    for (int i = 0; i < numRows; i++) {
      List<Integer> curr = new ArrayList<Integer>();
      if (i == 0) {
        curr.add(1);
      } else {
        for (int j = 0; j <= i; j++) {
          if (j == 0 || j == i) {
            curr.add(1);
          } else {
            curr.add(prev.get(j - 1) + prev.get(j));
          }
        }
      }
      prev = curr;
      res.add(curr);
    }

    return res;
  }
}

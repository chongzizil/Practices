package com.zil.li.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 3/12/15.
 *
 * https://leetcode.com/problems/pascals-triangle-ii/
 */
public class PascalTriangleII {
  public List<Integer> getRow(int rowIndex) {
    List<Integer> prev = new ArrayList<Integer>();

    for (int i = 0; i <= rowIndex; i++) {
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
    }

    return prev;
  }
}

package com.zil.li.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 3/12/15.
 *
 * https://leetcode.com/problems/pascals-triangle-ii/
 */
public class PascalTriangleII {
  public List<Integer> getRow(int k) {
    List<Integer> curr = new ArrayList<>();

    for (int i = 0; i <= k; i++) {
      List<Integer> next = new ArrayList<>();
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          next.add(1);
        } else {
          next.add(curr.get(j - 1) + curr.get(j));
        }
      }
      curr = next;
    }

    return curr;
  }
}

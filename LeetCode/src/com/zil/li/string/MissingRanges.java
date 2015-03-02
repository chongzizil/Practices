package com.zil.li.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 1/28/15.
 *
 * https://oj.leetcode.com/problems/missing-ranges/
 */
public class MissingRanges {
  /**
   * Time complexity: O(n)
   * Space complexity: O(1)
   * Runtime: 205 ms
   */
  public List<String> solutionA(int[] A, int lower, int upper) {
    List<String> res = new ArrayList<String>();
    int l = lower;
    int r = upper;

    for (int i = 0; i < A.length; i++) {
      if (l == A[i]) {
        l++;
      } else {
        r = A[i] - 1;
        if (l == r) {
          res.add(String.valueOf(l));
        } else {
          res.add(l + "->" + r);
        }
        l = A[i] + 1;
      }
    }

    if (l <= upper) {
      if (l == upper) {
        res.add(String.valueOf(l));
      } else {
        res.add(l + "->" + upper);
      }
    }

    return res;
  }

  /**
   * Basically we just need to check each two elements in the array. In order to
   * deal with the corner cases, we "insert" two elements into the head and tail
   * of that array.
   * Time complexity: O(n)
   * Space complexity: O(1)
   * Runtime: 198 ms
   */
  public List<String> solutionB(int[] A, int lower, int upper) {
    List<String> res = new ArrayList<String>();
    int prev = lower - 1; // Note: remember the corner case for lower bound and upper bound

    for (int i = 0; i <= A.length; i++) {
      int curr = i == A.length ? upper + 1 : A[i];
      if (curr - prev >= 2) {
        res.add(getRangeStr(prev + 1, curr - 1));
      }
      prev = curr;
    }

    return res;
  }

  public String getRangeStr(int l, int r) {
    return l == r ? String.valueOf(l) : l + "->" + r;
  }
}

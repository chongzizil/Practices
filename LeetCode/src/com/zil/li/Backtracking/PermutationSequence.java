package com.zil.li.Backtracking;

import java.util.LinkedList;

/**
 * Created by youlongli on 3/6/15.
 *
 * https://oj.leetcode.com/problems/permutation-sequence/
 *
 * Code Ref: http://www.cnblogs.com/yuzhangcmu/p/4224575.html
 */
public class PermutationSequence {
  public String getPermutation(int n, int k) {
    LinkedList<Character> digits = new LinkedList<Character>();

    // Starts from '1' to n
    for (char i = '1'; i <= '0' + n; i++) {
      digits.add(i);
    }

    k--;
    StringBuilder sb = new StringBuilder();

    int sum = 1;
    for (int i = 1; i <= n; i++) {
      sum *= i;
    }

    for (int i = n; i >= 1; i--) {
      sum /= i;
      // Index of the digit in the list.
      // e.g. for the first digit, there are (n - 1)! possibilities for each number, so its index is (k / sum) where k is 0 based
      int digitIndex = k / sum;
      k = k % sum;

      sb.append(digits.get(digitIndex));

      digits.remove(digitIndex);
    }

    return sb.toString();
  }
}

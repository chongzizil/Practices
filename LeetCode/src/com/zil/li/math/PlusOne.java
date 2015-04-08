package com.zil.li.math;

/**
 * Created by youlongli on 3/1/15.
 *
 * https://oj.leetcode.com/problems/plus-one/
 *
 * Idea: If instead of passing an array, it's a list, then there's no need to create a new array if
 * we hit the corner case. We can add one more 0 at the end and set the first element to 1. (999 + 1 = 1000)
 */
public class PlusOne {
  public int[] solutionA(int[] digits) {
    int carry = 1;
    for (int i = digits.length - 1; i >= 0; i--) {
      if (carry == 0) {
        return digits; // If the carry is already 0, no need for further calculation.
      }

      int sum = digits[i] + carry;
      carry = sum / 10;
      digits[i] = sum % 10;
    }

    if (carry == 0) {
      return digits;
    }

    int[] newDigits = new int[digits.length + 1];

    newDigits[0] = 1;
    for (int i = 0; i < digits.length; i++) {
      newDigits[i + 1] = digits[i];
    }

    return newDigits;
  }
}

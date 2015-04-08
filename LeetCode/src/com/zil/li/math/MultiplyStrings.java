package com.zil.li.math;

/**
 * Created by youlongli on 3/10/15.
 *
 * https://leetcode.com/problems/multiply-strings/
 *
 * Ref: http://www.cnblogs.com/yuzhangcmu/p/4116211.html
 */
public class MultiplyStrings {
  public String multiply(String num1, String num2) {
    if (num1 == null || num2 == null) {
      return null;
    }

    int len1 = num1.length();
    int len2 = num2.length();
    int[] sum = new int[len1 + len2];
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < len1; i++) {
      for (int j = 0; j < len2; j++) {
        sum[i + j] += (num1.charAt(len1 - 1 - i) - '0') * (num2.charAt(len2 - 1 - j) - '0');
      }
    }

    int carry = 0;
    for (int i = 0; i < sum.length; i++) {
      sum[i] += carry;
      carry = sum[i] / 10;
      sum[i] %= 10;
    }

    for (int i = sum.length - 1; i >= 0; i--) {
      sb.append(sum[i]);
    }

    while (sb.charAt(0) == '0' && sb.length() > 1) { // Delete all leading zeros
      sb.deleteCharAt(0);
    }

    return sb.toString();
  }
}

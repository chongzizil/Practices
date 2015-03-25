package com.zil.li.string;

/**
 * Created by youlongli on 3/24/15.
 *
 * https://leetcode.com/problems/add-binary/
 */
public class AddBinary {
  public String addBinary(String a, String b) {
    int lenA = a.length();
    int lenB = b.length();
    if (lenA < lenB) return addBinary(b, a);

    int carry = 0;
    int i = lenA - 1;
    int j = lenB - 1;
    StringBuilder sb = new StringBuilder();

    while (j >= 0) {
      int digitA = a.charAt(i--) - '0';
      int digitB = b.charAt(j--) - '0';
      int sum = digitA + digitB + carry;
      sb.append(String.valueOf(sum % 2));
      carry = sum / 2;
    }

    while (i >= 0) {
      int digitA = a.charAt(i--) - '0';
      int sum = digitA + carry;
      sb.append(String.valueOf(sum % 2));
      carry = sum / 2;
    }

    if (carry == 1) {
      sb.append("1");
    }

    return sb.reverse().toString();
  }
}

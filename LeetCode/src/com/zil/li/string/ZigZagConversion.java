package com.zil.li.string;

/**
 * Created by youlongli on 3/10/15.
 *
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigZagConversion {
  public String convert(String s, int nRows) {
    StringBuilder sb = new StringBuilder();
    int n = s.length();

    if (nRows == 1) {
      return s;
    }

    for (int i = 0; i < nRows; i++) {
      int j = i;
      while (j < n) {
        sb.append(s.charAt(j));
        if (i == 0 || i == nRows - 1) {
          j += 2 * (nRows - 1);
        } else {
          j += 2 * (nRows - i - 1);
          if (j < n) {
            sb.append(s.charAt(j));
            j += 2 * i; // Note: Not 2 * (i + 1)
          }
        }
      }
    }

    return sb.toString();
  }
}

package com.zil.li.math;

/**
 * Created by youlongli on 3/15/15.
 *
 * https://leetcode.com/problems/excel-sheet-column-number/
 */
public class ExcelSheetColumnNumber {
  public int titleToNumber(String s) {
    int res = 0;
    int pow = 0; // Start at 0

    for (int i = s.length() - 1; i >= 0; i--) {
      res += (s.charAt(i) - 'A' + 1) * Math.pow(26, pow++);
    }

    return res;
  }
}

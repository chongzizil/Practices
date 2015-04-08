package com.zil.li.math;

/**
 * Created by youlongli on 3/15/15.
 *
 * https://leetcode.com/problems/excel-sheet-column-number/
 */
public class ExcelSheetColumnNumber {
  public int titleToNumber(String s) {
    int res = 0;

    for (int i = s.length() - 1; i >= 0; i--) {
      res += Math.pow(26, s.length() - i - 1) * (s.charAt(i) - 'A' + 1);
    }

    return res;
  }
}

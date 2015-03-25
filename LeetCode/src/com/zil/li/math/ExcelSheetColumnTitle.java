package com.zil.li.math;

/**
 * Created by youlongli on 3/15/15.
 *
 * https://leetcode.com/problems/excel-sheet-column-title/
 */
public class ExcelSheetColumnTitle {
  public String convertToTitle(int n) {
    StringBuilder sb = new StringBuilder();

    while (n > 0) {
      // Each time extract the last "digit" and get the char/title
      // E.g. 123 % 10 to get LSD, then 123 % 26 to get LSD for this problem
      sb.append((char)((n - 1) % 26 + 'A'));
      n = (n - 1) / 26;
    }

    return sb.reverse().toString();
  }
}

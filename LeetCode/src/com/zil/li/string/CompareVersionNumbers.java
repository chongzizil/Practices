package com.zil.li.string;

/**
 * Created by youlongli on 2/28/15.
 *
 * https://leetcode.com/problems/compare-version-numbers/
 */
public class CompareVersionNumbers {
  public int compareVersion(String version1, String version2) {
    String []num1 = version1.split("\\.");
    String []num2 = version2.split("\\.");
    int maxLen = Math.max(num1.length, num2.length);

    for (int i = 0; i < maxLen; i++) {
      int n1 = i < num1.length ? Integer.parseInt(num1[i]) : 0;
      int n2 = i < num2.length ? Integer.parseInt(num2[i]) : 0;
      if (n1 > n2) {
        return 1;
      } else if (n1 < n2) {
        return -1;
      }
    }

    return 0;
  }
}

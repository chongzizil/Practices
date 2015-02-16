package com.zil.li.string;

/**
 * Created by youlongli on 12/30/14.
 *
 * Some details:
 * 1. Algorithms such as KMP can be more efficient, yet too complex for an interview.
 */
public class ImplementStrStr {
  /**
   * Brutal force
   * Time complexity: O(nm) (Worst case. n: length of haystack. m: length of needle)
   * Space complexity: O(1)
   * Runtime: 440 ms
   */
  public int solutionA(String haystack, String needle) {
    if (haystack == null || needle == null) {
      return -1;
    }

    for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
      int j;
      for (j = 0; j < needle.length(); j++) {
        if (haystack.charAt(i + j) != needle.charAt(j)) {
          break;
        }
      }
      if (j == needle.length()) {
        return i;
      }
    }

    return -1;
  }
}

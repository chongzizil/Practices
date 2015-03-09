package com.zil.li.string;

import java.util.Arrays;

/**
 * Created by youlongli on 1/21/15.
 *
 * https://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {
  /**
   * One pass solution with two pointers. Assume the characters are all ASCII only.
   * Time complexity: O(n)
   * Space complexity: O(1)
   * Runtime: 261 ms
   */
  public int solutionA(String s) {
    if (s == null) {
      return 0;
    }

    int res = 0;
    int n = s.length();
    int[] map = new int[128];

    Arrays.fill(map, -1);

    int start = 0;
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      if (map[c] >= start) {
        res = Math.max(res, i - start);
        start = map[c] + 1;
      }

      map[c] = i;
    }

    return Math.max(res, n - start);
  }
}

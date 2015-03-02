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
    int start = 0;
    int[] map = new int[256]; // Stores the index of the last appearance of that character

    Arrays.fill(map, -1);
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      // Find duplicate
      if (map[c] >= start) {
        res = Math.max(res, i - start);
        start = map[c] + 1; // Update the start index of the substring
      }

      map[c] = i;
    }

    return Math.max(res, s.length() - start);
  }
}

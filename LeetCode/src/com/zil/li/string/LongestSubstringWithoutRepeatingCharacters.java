package com.zil.li.string;

/**
 * Created by youlongli on 1/21/15.
 */
public class LongestSubstringWithoutRepeatingCharacters {
  /**
   * One pass solution with two pointers. Assume the characters are all ASCII only.
   * Time complexity: O(n)
   * Space complexity: O(1)
   * Runtime: 261 ms
   */
  public int solutionA(String s) {
    int res = 0;
    int start = 0;
    int[] dict = new int[256];

    for (int i = 0; i < 256; i++) {
      dict[i] = -1;
    }

    for (int curr = 0; curr < s.length(); curr++) {
      char c = s.charAt(curr);
      // Found a repeated character, update the start index.
      if (dict[c] >= start) {
        start = dict[c] + 1;
      }
      dict[c] = curr;
      // Update the max length of non-repeated substring
      res = Math.max(curr - start + 1, res);
    }

    return res;
  }
}

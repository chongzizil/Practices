package com.zil.li.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by youlongli on 1/28/15.
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
  /**
   * This is a relatively slow and complicated solution. Basic idea is to track the characters
   * in a substring by using a map.
   * Time complexity: O(n)
   * Space complexity: O(1)
   * Runtime: 307 ms
   */
  public int solutionA(String s) {
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    char c1 = ' ';
    char c2 = ' ';
    int tmp = 0;
    int res = 0;

    for (int i = 0; i < s.length(); i++) {
      if (map.size() == 0) {
        c1 = s.charAt(i);
      } else if (map.size() == 1) {
        c2 = s.charAt(i);
      } else if (!map.containsKey(s.charAt(i))) {
        int newStart = 0;
        if (map.get(c1) > map.get(c2)) {
          newStart = map.get(c2) + 1;
          map.remove(c2);
          c2 = s.charAt(i);
        } else {
          newStart = map.get(c1) + 1;
          map.remove(c1);
          c1 = s.charAt(i);
        }
        res = Math.max(res, tmp);
        tmp = i - newStart;
      }
      map.put(s.charAt(i), i);
      tmp++;
    }
    res = Math.max(res, tmp);

    return res;
  }

  /**
   * This solution use three pointers to make sure that only two distinct
   * characters in the sliding window.
   * i: The position of the first of the current character
   * j: The position of the last of the the other character
   * Time complexity: O(n)
   * Space complexity: O(1)
   * Runtime: 208 ms
   */
  public int solutionB(String s) {
    if (s == null) {
      return 0;
    }

    int i = 0, j = -1, maxLen = 0;
    for (int k = 1; k < s.length(); k++) {
      // If the character is as same as the previous one, skip
      if (s.charAt(k) == s.charAt(k - 1)) continue;
      // If the character is not as same as another distinct character of the substring
      if (j >= 0 && s.charAt(j) != s.charAt(k)) {
        maxLen = Math.max(k - i, maxLen);
        i = j + 1;
      }
      j = k - 1;
    }
    return Math.max(s.length() - i, maxLen);
  }

  /**
   * This solution is more general, hence can be easily modified for n distinct characters. (ASCII)
   * Time complexity: O(n)
   * Space complexity: O(1)
   * Runtime: 205 ms
   */
  public int solutionC(String s) {
    int[] count = new int[256];
    int i = 0, numDistinct = 0, maxLen = 0;
    for (int j = 0; j < s.length(); j++) {
      if (count[s.charAt(j)] == 0) numDistinct++;
      count[s.charAt(j)]++;
      while (numDistinct > 2) {
        count[s.charAt(i)]--;
        if (count[s.charAt(i)] == 0) numDistinct--;
        i++;
      }
      maxLen = Math.max(j - i + 1, maxLen);
    }
    return maxLen;
  }
}

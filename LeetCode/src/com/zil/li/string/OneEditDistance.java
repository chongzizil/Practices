package com.zil.li.string;

/**
 * Created by youlongli on 1/28/15.
 *
 * https://oj.leetcode.com/problems/one-edit-distance/
 */
public class OneEditDistance {
  /**
   * First make sure the length of s is longer or equal to the length of t which
   * make the life easier...
   * Then for each case:
   * ls == lt: only modify one character
   * ls == lt + 1: either append one character at the end of t, or insert one in the middle of t
   * ls > lt + 1: return false
   * Time complexity: O(n)
   * Space complexity: O(1)
   * Runtime: 260 ms
   */
  public boolean solutionA(String s, String t) {
    if (s == null || t == null || Math.abs(s.length() - t.length()) > 1) {
      return false;
    }

    int lenS = s.length();
    int lenT = t.length();
    if (lenS < lenT) return solutionA(t, s);

    int i = 0;
    int diff = lenS - lenT;

    while (i < lenT && s.charAt(i) == t.charAt(i)) i++;
    // If t matches all characters in s, then return true if s is longer than t
    if (i == lenT) return diff == 1;
    // If s and t has the same length, skip the character on both sides
    // Otherwise only skip on s....
    if (lenS == lenT) i++;
    while (i < lenT && s.charAt(i + diff) == t.charAt(i)) i++;
    return i == lenT;
  }
}

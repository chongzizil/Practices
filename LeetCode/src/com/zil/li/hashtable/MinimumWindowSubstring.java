package com.zil.li.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by youlongli on 3/8/15.
 *
 * https://oj.leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {
  public String minWindow(String S, String T) {
    if (S == null || S.length() == 0) {
      return S;
    }
    if (T == null || T.length() == 0) {
      return "";
    }

    Map<Character, Integer> minWinCount = new HashMap<Character, Integer>();
    Map<Character, Integer> dict = new HashMap<Character, Integer>();
    String minWinStr = "";
    int beg = 0; // Begin of the substring
    int dictCount = 0; // Count of T characters in the substring

    for (int i = 0; i < T.length(); i++) {
      char c = T.charAt(i);
      if (dict.containsKey(c)) {
        dict.put(c, dict.get(c) + 1);
      } else {
        dict.put(c, 1);
      }
    }

    for (int i = 0; i < S.length(); i++) {
      char c = S.charAt(i);
      if (!dict.containsKey(c)) {
        continue; // Skip
      }

      if (minWinCount.containsKey(c)) {
        minWinCount.put(c, minWinCount.get(c) + 1);
      } else {
        minWinCount.put(c, 1);
      }

      if (minWinCount.get(c) <= dict.get(c)) {
        dictCount++;
      }

      if (dictCount == T.length()) {
        while (beg < S.length()) {
          char begC = S.charAt(beg);
          if (!dict.containsKey(begC)) {
            beg++;
            continue;
          }
          if (minWinCount.get(begC) > dict.get(begC)) {
            minWinCount.put(begC, minWinCount.get(begC) - 1);
            beg++;
            continue;
          }
          break;
        }

        if (minWinStr.equals("") || i - beg + 1 < minWinStr.length()) {
          minWinStr = S.substring(beg, i + 1);
        }
      }
    }

    return minWinStr;

  }
}

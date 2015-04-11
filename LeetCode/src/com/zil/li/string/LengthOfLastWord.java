package com.zil.li.string;

/**
 * Created by youlongli on 3/24/15.
 *
 * https://leetcode.com/problems/length-of-last-word/
 */
public class LengthOfLastWord {
  public int lengthOfLastWordA(String s) {
    int end = s.length();

    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == ' ') {
        end = i;
      } else if (i == 0 || s.charAt(i - 1) == ' ') {
        return end - i;
      }
    }

    return 0;
  }

  public int lengthOfLastWordB(String s) {
    int end = s.length();

    for (int i = s.length() - 1; i >= 0; i--) {
      char c = s.charAt(i);
      if (c == ' ') {
        if (end - i >= 2) { // We have a word!
          return end - i - 1;
        }
        // No word found, update end.
        end = i;
      }
    }

    // Check if there's only one word.
    if (end != 0) {
      return end;
    }

    return 0;
  }
}

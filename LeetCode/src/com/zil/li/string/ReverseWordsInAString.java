package com.zil.li.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 12/30/14.
 *
 * https://oj.leetcode.com/problems/reverse-words-in-a-string/
 */
public class ReverseWordsInAString {
  /**
   * One pass without split and trim
   * Time complexity: O(n)
   * Space complexity: O(n)
   * Runtime: 230 ms
   *
   * Be careful of corner case such as empty string.
   */
  public String solutionA(String s) {
    if (s == null) {
      return null;
    }

    StringBuilder sb = new StringBuilder();
    int end = s.length();

    for (int beg = s.length() - 1; beg >= 0; beg--) {
      // Note: First check if the current character is ' ' and then check if a word is finished.
      if (s.charAt(beg) == ' ') {
        end = beg;
      } else if (beg == 0 || s.charAt(beg - 1) == ' ') {
        if (sb.length() > 0) {
          sb.append(" ");
        }
        sb.append(s.substring(beg, end));
      }
    }

    return sb.toString();
  }

  /**
   * Two pass with Split and trim
   * Time complexity: O(n)
   * Space complexity: O(n)
   * Runtime: 432 ms
   */
  public String solutionC(String s) {
    String[] words = s.trim().split("\\s+");
    StringBuilder sb = new StringBuilder();

    for (int i = words.length - 1; i >= 0; i--) {
      sb.append(words[i]);
      sb.append(" ");
    }

    if (sb.length() > 0) {
      sb.setLength(sb.length() - 1);
    }

    return sb.toString();
  }

  /**
   * Two pass without split and trim.
   * Time complexity: O(n)
   * Space complexity: O(n)
   * Runtime: 428 ms
   */
  public String solutionB(String s) {
    StringBuilder sb = new StringBuilder();
    List<String> words = new ArrayList<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c != ' ') {
        sb.append(c);
      } else if (sb.length() > 0) {
        words.add(sb.toString());
        sb.setLength(0);
      }
    }

    if (sb.length() > 0) {
      words.add(sb.toString());
      sb.setLength(0);
    }

    for (int i = words.size() - 1; i >= 0; i--) {
      sb.append(words.get(i));
      sb.append(" ");
    }

    if (sb.length() > 0) {
      sb.setLength(sb.length() - 1);
    }

    return sb.toString();
  }
}

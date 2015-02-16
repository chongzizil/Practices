package com.zil.li.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 12/30/14.
 */
public class ReverseWordsInAString {
  /**
   * Two pass with Split and trim
   * Time complexity: O(n)
   * Space complexity: O(n)
   * Runtime: 432 ms
   */
  public String solutionA(String s) {
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

  /**
   * One pass without split and trim
   * Time complexity: O(n)
   * Space complexity: O(n)
   * Runtime: 392 ms
   *
   * Be careful of corner case such as empty string.
   */
  public String solutionC(String s) {
    StringBuilder sb = new StringBuilder();
    List<String> words = new ArrayList<>();
    int j = s.length();

    for (int i = s.length() - 1; i >= 0; i--) {
      char c = s.charAt(i);

      if (c == ' ') {
        j = i;
      } else if (i == 0 || s.charAt(i - 1) == ' ') {
        if (sb.length() > 0) {
          sb.append(" ");
        }
        sb.append(s.substring(i, j));
      }
    }

    return sb.toString();
  }
}

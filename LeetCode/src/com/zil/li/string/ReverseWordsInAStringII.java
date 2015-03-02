package com.zil.li.string;

/**
 * Created by youlongli on 1/5/15.
 *
 * https://oj.leetcode.com/submissions/detail/22051307/
 *
 * Added constraints: “The input string does not contain leading or trailing spaces and the words are always separated by a single space.”
 */
public class ReverseWordsInAStringII {
  /**
   * Two pass solution. This should be the better one.
   * Runtime: 219 ms
   */
  public void solutionA(char[] s) {
    if (s == null) {
      return;
    }

    reverse(s, 0, s.length);

    int end = s.length;
    for (int beg = s.length - 1; beg >= 0; beg--) {
      if (s[beg] == ' ') {
        end = beg;
      } else if (beg == 0 || s[beg - 1] == ' ') {
        reverse(s, beg, end);
      }
    }
  }

  private void reverse(char[] s, int beg, int end) {
    end--;
    for (; beg < end; beg++, end--) {
      char tmp = s[beg];
      s[beg] = s[end];
      s[end] = tmp;
    }
  }

  /**
   * Two pass without split and trim. First reverse the whole string, then
   * reverse each individual words.
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public void solutionB(char[] s) {
    reverseStringB(s, 0, s.length - 1);
    int start = 0;
    for (int i = 0; i <= s.length; i++) {
      if (i == s.length || s[i] == ' ') {
        reverseStringB(s, start, i - 1);
        start = i + 1;
      }
    }
  }

  /**
   * Reverse the string by using two pointers.
   */
  private void reverseStringB(char[] s, int start, int end) {
    int l = start;
    int r = end;

    while (l < r) {
      char tmp = s[l];
      s[l] = s[r];
      s[r] = tmp;
      l++;
      r--;
    }
  }

  /**
   * Another way to reverse the string.
   */
  private void reverseStringC(char[] s, int start, int end) {
    for (int i = 0; i < (end + 1 - start) / 2; i++) {
      char tmp = s[start + i];
      s[start + i] = s[end - i - 1];
      s[end - i - 1] = tmp;
    }
  }
}

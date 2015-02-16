package com.zil.li.string;

/**
 * Created by youlongli on 1/5/15.
 *
 * Added constraints: “The input string does not contain leading or trailing spaces and the words are always separated by a single space.”
 */
public class ReverseWordsInAStringII {
  /**
   * Two pass solution. This should be the better one.
   * Runtime: 229 ms
   */
  public void solutionA(char[] s) {
    reverse(s, 0, s.length);

    int j = s.length;
    for (int i = s.length - 1; i >= 0; i--) {
      if (s[i] == ' ') {
        j = i;
      } else if (i == 0 || s[i - 1] == ' ') {
        reverse(s, i, j);
      }
    }
  }

  private void reverse(char[] s, int beg, int end) {
    for (int i = beg, j = end - 1; i < j; i++, j--) {
      char tmp = s[i];
      s[i] = s[j];
      s[j] = tmp;
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

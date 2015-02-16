package com.zil.li.string;

/**
 * Created by youlongli on 1/6/15.
 *
 * Some details:
 * 1. All spaces are discarded until the first non-space character.
 * 2. One unary operator is accepted.
 * 3. Stops as soon as a non-numerical character is encountered.
 * 4. Return MAX or MIN if overflowed.
 */
public class StringToInteger {
  private static final int MAX = Integer.MAX_VALUE;
  private static final int MIN = Integer.MIN_VALUE;

  /**
   * Basic solution.
   * Time complexity: O(n)
   * Space complexity: O(1)
   * Runtime: 217 ms
   */
  public int solutionA(String str) {
    if (str == null) {
      return 0;
    }

    int res = 0;
    int sign = 1; // Positive
    int i = 0;
    int n = str.length();

    // Skip all leading spaces
    while (i < n && str.charAt(i) == ' ') {
      i++;
    }

    // Check unary operator
    if (i < n && str.charAt(i) == '+') {
      i++;
    } else if (i < n && str.charAt(i) == '-') {
      sign = -1;
      i++;
    }

    // Process digit by digit. Stop if the character is not a digit
    while (i < n && Character.isDigit(str.charAt(i))) {
      int digit = str.charAt(i) - '0';
      // Check overflow
      if (sign == 1 && (res > MAX / 10 || (res == MAX / 10 && digit >= MAX % 10))) {
        return MAX;
      } else if (sign == -1 && (-res < MIN / 10 || (-res == MIN / 10 && -digit <= MIN % 10))) {
        return MIN;
      }

      res = res * 10 + digit;
      i++;
    }

    return res * sign;
  }

  /**
   * Solution using long to deal with overflow which makes the code cleaner (this might not meet the requirements).
   * Time complexity: O(n)
   * Space complexity: O(1)
   * Runtime: 231 ms
   */
  public int solutionB(String str) {
    if (str == null) return 0;

    long res = 0;
    int sign = 1;
    int i = 0;

    // Skip all heading spaces
    while (i < str.length() && str.charAt(i) == ' ') {
      i++;
    }

    if (i == str.length()) return 0;

    // Process unary operator
    if (str.charAt(i) == '-') {
      sign = -1;
      i++;
    } else if (str.charAt(i) == '+') {
      i++;
    }

    // Process digits and stop if the next character is not a number
    while (i < str.length() && Character.isDigit(str.charAt(i))) {
      int newDigit = str.charAt(i) - '0';
      res = res * 10 + newDigit;
      if (sign == 1 && res > MAX) {
        return MAX;
      } else if (sign == -1 && -res < MIN) {
        return MIN;
      }

      i++;
    }

    return (int) res * sign;
  }
}

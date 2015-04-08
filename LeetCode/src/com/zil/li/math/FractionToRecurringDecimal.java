package com.zil.li.math;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by youlongli on 4/5/15.
 *
 * https://leetcode.com/problems/fraction-to-recurring-decimal/
 *
 * Idea: Remember how to do divide.
 */
public class FractionToRecurringDecimal {
  public String fractionToDecimal(int numerator, int denominator) {
    if (numerator == 0) {
      return "0"; // Corner case
    }

    StringBuilder sb = new StringBuilder();
    sb.append((numerator < 0 ^ denominator < 0) ? "-" : ""); // Check if it's negative

    long num = Math.abs((long)numerator);
    long den = Math.abs((long)denominator);

    // The integral part before .
    sb.append(num / den);
    num = num % den;
    if (num == 0) {
      return sb.toString(); // The result is int
    }

    // After .
    // Key: numerator, Value: index of the StringBuilder
    Map<Long, Integer> map = new HashMap<>();
    sb.append(".");
    map.put(num, sb.length());

    while (num > 0) {
      // Multiply by 10 first, recall how to do the math by hand
      num *= 10;
      sb.append(num / den);
      num %= den;
      // Check if the numerator exist in the map, which will reduce the same and repeating decimal
      if (map.containsKey(num)) {
        // Get the index of the start of the pattern, insert "(" and append ")", then return.
        int index = map.get(num);
        sb.insert(index, "(");
        sb.append(")");
        return sb.toString();
      } else {
        map.put(num, sb.length());
      }
    }

    return sb.toString();
  }
}

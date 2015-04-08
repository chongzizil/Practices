package com.zil.li.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by youlongli on 4/1/15.
 *
 * https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {
  public int romanToInt(String s) {
    if (s == null || s.length()==0) {
      return 0;
    }
    Map<Character, Integer> m = new HashMap<Character, Integer>();
    m.put('I', 1);
    m.put('V', 5);
    m.put('X', 10);
    m.put('L', 50);
    m.put('C', 100);
    m.put('D', 500);
    m.put('M', 1000);

    int length = s.length();
    int result = m.get(s.charAt(length - 1));
    for (int i = length - 2; i >= 0; i--) {
      if (m.get(s.charAt(i)) >= m.get(s.charAt(i + 1))) {
        result += m.get(s.charAt(i));
      } else {
        result -= m.get(s.charAt(i));
      }
    }
    return result;
  }
}

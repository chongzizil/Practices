package com.zil.li.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by youlongli on 3/2/15.
 *
 * https://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfAPhoneNumber {
  public List<String> letterCombinations(String digits) {
    List<String> res = new ArrayList<String>();
    StringBuilder sb = new StringBuilder();

    // Need to handle empty string here.
    if (digits == null || digits.length() == 0) {
      return res;
    }

    Map<Character, char[]> map = new HashMap<Character, char[]>();
    map.put('2', new char[]{'a', 'b', 'c'});
    map.put('3', new char[]{'d', 'e', 'f'});
    map.put('4', new char[]{'g', 'h', 'i'});
    map.put('5', new char[]{'j', 'k', 'l'});
    map.put('6', new char[]{'m', 'n', 'o'});
    map.put('7', new char[]{'p', 'q', 'r', 's'});
    map.put('8', new char[]{'t', 'u', 'v'});
    map.put('9', new char[]{'w', 'x', 'y', 'z'});

    helper(res, map, sb, digits);

    return res;
  }

  private void helper( List<String> res, Map<Character, char[]> map, StringBuilder sb, String digits) {
    if (sb.length() == digits.length()) {
      res.add(sb.toString());
      return;
    }

    for (char c : map.get(digits.charAt(sb.length()))) {
      sb.append(c);
      helper(res, map, sb, digits);
      sb.setLength(sb.length() - 1);
    }
  }
}

package com.zil.li.string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by youlongli on 4/1/15.
 *
 * https://leetcode.com/problems/integer-to-roman/
 */
public class IntegerToRoman {
  public static String intToRoman(int num) {
    // Key: number, Value: roman str (the key is ordered by using linkedHashMap)
    Map<Integer, String> numToRoman = new LinkedHashMap<Integer, String>();
    numToRoman.put(1000, "M");
    numToRoman.put(900, "CM");
    numToRoman.put(500, "D");
    numToRoman.put(400, "CD");
    numToRoman.put(100, "C");
    numToRoman.put(90, "XC");
    numToRoman.put(50, "L");
    numToRoman.put(40, "XL");
    numToRoman.put(10, "X");
    numToRoman.put(9, "IX");
    numToRoman.put(5, "V");
    numToRoman.put(4, "IV");
    numToRoman.put(1, "I");

    StringBuilder sb = new StringBuilder();

    while (num > 0) {
      for (int key : numToRoman.keySet()) {
        if (num >= key) {
          sb.append(numToRoman.get(key));
          num -= key;
          break;
        }
      }
    }

    return sb.toString();
  }
}

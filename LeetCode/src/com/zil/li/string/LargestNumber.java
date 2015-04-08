package com.zil.li.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by youlongli on 3/11/15.
 *
 * https://leetcode.com/problems/largest-number/
 */
public class LargestNumber {
  private Comparator<String> comparator = new Comparator<String>() {
    public int compare(String num1, String num2) {
      String str1 = num2 + num1;
      String str2 = num1 + num2;
      return str1.compareTo(str2);
    }
  };

  public String largestNumber(int[] num) {
    List<String> list = new ArrayList<String>();

    for (int i : num) {
      list.add(String.valueOf(i));
    }

    Collections.sort(list, comparator);

    StringBuilder sb = new StringBuilder();
    for (String str : list) {
      sb.append(str);
    }

    while (sb.length() > 1 && sb.charAt(0) == '0') {
      sb.deleteCharAt(0); // Corner case such as [0, 0], [0, 0, 0]
    }
    return sb.toString();
  }
}

package com.zil.li.string;

/**
 * Created by youlongli on 3/22/15.
 */
public class LongestCommonPrefix {
  public String longestCommonPrefixA(String[] strs) {
    if (strs.length == 0) {
      return ""; // Note: Check First
    }

    int i = 0;
    char curr = ' ';

    while (true) {
      // In case first string ends...
      if (i >= strs[0].length()) {
        return strs[0].substring(0, i);
      }

      curr = strs[0].charAt(i);
      // Check the rest of strings for the curr char
      for (int j = 1; j < strs.length; j++) {
        if (i >= strs[j].length() || strs[j].charAt(i) != curr) {
          // Found the longest one.
          return strs[0].substring(0, i);
        }
      }
      i++;
    }
  }

  public String longestCommonPrefixB(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    String prefix = strs[0];
    for(int i = 1; i < strs.length; i++) {
      int j = 0;
      while( j < strs[i].length() && j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j)) {
        j++;
      }
      if( j == 0) {
        return "";
      }
      prefix = prefix.substring(0, j);
    }
    return prefix;
  }
}

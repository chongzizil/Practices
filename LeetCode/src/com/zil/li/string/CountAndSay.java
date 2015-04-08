package com.zil.li.string;

/**
 * Created by youlongli on 3/23/15.
 *
 * https://leetcode.com/problems/count-and-say/
 */
public class CountAndSay {
  public String countAndSayA(int n) {
    String res = "1";

    for (int i = 1; i < n; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < res.length(); j++) {
        int count = 1;
        while (j + 1 < res.length() && res.charAt(j) == res.charAt(j + 1)) {
          count++;
          j++;
        }
        sb.append(String.valueOf(count) + res.charAt(j));
      }

      res = sb.toString();
    }

    return res;
  }

  public String countAndSayB(int n) {
    if (n == 0) {
      return "";
    }

    String res = "1";

    for (int i = 1; i < n; i++) {
      StringBuilder sb = new StringBuilder();
      char last = res.charAt(0);
      int count = 1;

      for (int j = 1; j < res.length(); j++) {
        if (res.charAt(j) == last) {
          count++;
        } else {
          sb.append(String.valueOf(count) + last);
          count = 1;
          last = res.charAt(j);
        }
      }

      if (count > 0) {
        sb.append(String.valueOf(count) + last);
      }

      res = sb.toString();
    }

    return res;
  }
}

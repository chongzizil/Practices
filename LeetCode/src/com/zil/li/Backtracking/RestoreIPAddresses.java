package com.zil.li.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 3/2/15.
 *
 * https://oj.leetcode.com/problems/restore-ip-addresses/
 */
public class RestoreIPAddresses {
  public List<String> restoreIpAddresses(String s) {
    List<String> res = new ArrayList<String>();
    List<String> list = new ArrayList<String>();

    if (s == null || s.length() < 4 || s.length() > 16) {
      return new ArrayList<String>();
    }

    helper(res, list, s, 0);

    return res;
  }

  private void helper(List<String> res, List<String> list, String s, int beg) {
    if (list.size() == 4) {
      if (s.length() != beg) return;

      StringBuilder sb = new StringBuilder();
      for (String part : list) {
        sb.append(part);
        sb.append(".");
      }
      sb.setLength(sb.length() - 1);
      res.add(sb.toString());
      return;
    }

    for (int i = beg; i <= beg + 3 && i < s.length(); i++) {
      String num = s.substring(beg, i + 1);
      if (isValid(num)) {
        list.add(num);
        helper(res, list, s, i + 1);
        list.remove(list.size() - 1);
      }
    }
  }

  private boolean isValid(String str) {
    if (str.charAt(0) == '0') {
      return str.equals("0");
    }
    int num = Integer.parseInt(str);
    return num >= 0 && num <= 255;
  }
}

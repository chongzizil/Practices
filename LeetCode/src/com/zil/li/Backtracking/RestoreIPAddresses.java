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

    if (s == null || s.length() < 4 || s.length() > 12) {
      return res;
    }

    helper(res, list, s, 0);

    return res;
  }

  private void helper(List<String> res, List<String> list, String s, int pos) {
    if (list.size() == 4 && pos == s.length()) {
      StringBuilder sb = new StringBuilder();
      for (String str : list) {
        sb.append(str);
        sb.append('.');
      }
      sb.setLength(sb.length() - 1);
      res.add(sb.toString());
    }

    for (int i = pos; i < s.length() && i < pos + 3; i++) {
      if (isValid(s.substring(pos, i + 1))) {
        list.add(s.substring(pos, i + 1));
        helper(res, list, s, i + 1);
        list.remove(list.size() - 1);
      }
    }
  }

  private boolean isValid(String s) {
    if (s.charAt(0) == '0') {
      return s.equals("0"); // e.g. 011 is not valid.
    }
    int num = Integer.parseInt(s);
    return num < 256;
  }
}

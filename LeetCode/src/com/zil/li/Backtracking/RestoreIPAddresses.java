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
    List<String> res = new ArrayList<>();
    List<String> list = new ArrayList<>();

    if (s.length() < 4 || s.length() > 12) {
      return res;
    }

    search(res, list, s, 0);

    return res;
  }

  private void search(List<String> res, List<String> list, String s, int pos) {
    if (list.size() == 4 && pos == s.length()) {
      res.add(generateIP(list));
      return;
    }

    if (list.size() == 4) {
      return;
    }

    for (int i = pos; i < pos + 3 && i < s.length(); i++) {
      if (isValid(s.substring(pos, i + 1))) {
        list.add(s.substring(pos, i + 1));
        search(res, list, s, i + 1);
        list.remove(list.size() - 1);
      }
    }
  }

  private String generateIP(List<String> list) {
    StringBuilder sb = new StringBuilder();
    for (String str : list) {
      sb.append(str);
      sb.append(".");
    }
    sb.setLength(sb.length() - 1);
    return sb.toString();
  }

  private boolean isValid(String s) {
    if (s.charAt(0) == '0') {
      return s.length() == 1; // e.g. 011 is not valid.
    }

    int num = Integer.parseInt(s);
    return num >= 1 && num <= 255;
  }
}

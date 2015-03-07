package com.zil.li.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 3/2/15.
 *
 * https://oj.leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {
  public List<String> solutionA(int n) {
    List<String> res = new ArrayList<String>();
    StringBuilder sb = new StringBuilder();

    helperA(res, sb, n, n);

    return res;
  }

  private void helperA(List<String> res, StringBuilder sb, int l, int r) {
    if (l > r || l < 0 || r < 0) { // Note: check the index! Otherwise will cause stack over flow...
      return;
    }

    if (l == 0 && r == 0) {
      res.add(sb.toString());
      return;
    }

    sb.append('(');
    helperA(res, sb, l - 1, r);
    sb.setLength(sb.length() - 1);

    sb.append(')');
    helperA(res, sb, l, r - 1);
    sb.setLength(sb.length() - 1);
  }

  public ArrayList<String> solutionB(int n) {
    ArrayList<String> res = new ArrayList<String>();
    helperB(res, "", n, n);
    return res;
  }

  public void helperB(List<String> res , String s, int left, int right) {
    if(left > right || left < 0 || right < 0) {
      return;
    }
    if(left == 0 && right == 0) {
      res.add(s);
      return;
    }

    helperB(res, s + "(", left - 1, right);
    helperB(res, s + ")", left, right - 1);
  }
}

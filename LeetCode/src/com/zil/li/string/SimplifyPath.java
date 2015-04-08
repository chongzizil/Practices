package com.zil.li.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by youlongli on 3/25/15.
 * <p>
 * https://leetcode.com/problems/simplify-path/
 */
public class SimplifyPath {
  public String simplifyPath(String path) {
    Deque<String> queue = new ArrayDeque<String>();

    String[] dirs = path.split("/");

    for (String dir : dirs) {
      if (dir.equals("..")) {
        if (!queue.isEmpty()) {
          queue.pollLast();
        }
      } else if (dir.length() > 0 && !dir.equals(".")) {
        queue.addLast(dir);
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append("/");

    // Since I'm using ArrayDeque, no need to reversely pop the elements...
    while (!queue.isEmpty()) {
      sb.append(queue.pollFirst());
      if (!queue.isEmpty()) sb.append("/");
    }

    return sb.toString();
  }
}

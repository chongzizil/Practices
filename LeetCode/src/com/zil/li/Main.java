package com.zil.li;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 12/30/14.
 */
public class Main {
  public static void main(String[] args) {
    reverseWords(" 1");
  }

  public static String reverseWords(String s) {
    StringBuilder sb = new StringBuilder();
    List<String> words = new ArrayList<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isLetter(c)) {
        sb.append(c);
      } else if (sb.length() > 0) {
        words.add(sb.toString());
        sb.setLength(0);
      }
    }

    if (sb.length() > 0) {
      words.add(sb.toString());
      sb.setLength(0);
    }

    for (int i = words.size() - 1; i >= 0; i--) {
      sb.append(words.get(i));
      sb.append(" ");
    }

    if (sb.length() > 0) {
      sb.setLength(sb.length() - 1);
    }

    return sb.toString();
  }
}

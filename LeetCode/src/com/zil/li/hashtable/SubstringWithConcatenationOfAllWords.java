package com.zil.li.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by youlongli on 3/7/15.
 *
 * https://oj.leetcode.com/problems/substring-with-concatenation-of-all-words/
 */
public class SubstringWithConcatenationOfAllWords {
  public List<Integer> findSubstring(String S, String[] L) {
    // Key: word, Value: count
    Map<String, Integer> dict = new HashMap<>();
    Map<String, Integer> found = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    int num = L.length;
    int len = L[0].length();

    for (String word : L) {
      if (dict.containsKey(word)) {
        dict.put(word, dict.get(word) + 1);
      } else {
        dict.put(word, 1);
      }
    }

    for (int i = 0; i < S.length() - num * len + 1; i++) {
      found.clear();
      int j = 0;
      for (;j < num; j++) {
        int k = i + j * len;
        String word = S.substring(k, k + len);

        if (!dict.containsKey(word)) {
          break;
        }

        if (found.containsKey(word)) {
          found.put(word, found.get(word) + 1);
        } else {
          found.put(word, 1);
        }

        if (found.get(word) > dict.get(word)) {
          break;
        }
      }

      if (j == num) {
        res.add(i);
      }
    }

    return res;
  }
}

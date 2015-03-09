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
    int m = L.length;
    int n = L[0].length();
    List<Integer> res = new ArrayList<Integer>();
    Map<String, Integer> dict = new HashMap<String, Integer>();
    Map<String, Integer> found = new HashMap<String, Integer>();

    for (String word : L) {
      if (!dict.containsKey(word)) {
        dict.put(word, 1);
      } else {
        dict.put(word, dict.get(word) + 1);
      }
    }

    // Note: remember to plus 1
    for (int i = 0; i < S.length() - n * m + 1; i++) {
      found.clear(); // Remember to clear the found map
      int j = 0;
      for (; j < m; j++) {
        int k = i + j * n;
        String tmp = S.substring(k, k + n);
        if (!dict.containsKey(tmp)) {
          break;
        }
        if (!found.containsKey(tmp)) {
          found.put(tmp, 1);
        } else {
          found.put(tmp, found.get(tmp) + 1);
        }
        if (found.get(tmp) > dict.get(tmp)) {
          break;
        }
      }
      if (j == m) {
        res.add(i);
      }
    }

    return res;
  }
}

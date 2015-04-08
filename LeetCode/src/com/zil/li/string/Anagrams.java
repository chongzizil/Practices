package com.zil.li.string;

import java.util.*;

/**
 * Created by youlongli on 3/1/15.
 *
 * https://oj.leetcode.com/problems/anagrams/
 */
public class Anagrams {
  /**
   * Use Arrays.sort()
   */
  public List<String> solutionA(String[] strs) {
    // Key: sorted str, value: anagrams
    Map<String, List<String>> map = new HashMap<String, List<String>>();
    List<String> res = new ArrayList<String>();

    if (strs == null) {
      return res;
    }

    for (String str : strs) {
      char[] strCharArray = str.toCharArray();
      Arrays.sort(strCharArray);
      String sortedStr = new String(strCharArray);

      if (!map.containsKey(sortedStr)) {
        map.put(sortedStr, new ArrayList<String>());
      }

      map.get(sortedStr).add(str);
    }

    for (String key : map.keySet()) {
      if (map.get(key).size() > 1) {
        res.addAll(map.get(key));
      }
    }

    return res;
  }

  /**
   * Use hash function
   */
  public List<String> anagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<String, List<String>>();
    List<String> res = new ArrayList<String>();

    for (String str : strs) {
      String key = getHash(str);

      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<String>());
      }

      map.get(key).add(str);
    }

    for (String key : map.keySet()) {
      if (map.get(key).size() > 1) {
        res.addAll(map.get(key));
      }
    }

    return res;
  }

  private String getHash(String s) {
    // Assume a-z input, all lower case
    int[] count = new int[26];
    char[] chars = s.toCharArray();
    StringBuilder sb = new StringBuilder();

    for (char c : chars) {
      count[c - 'a']++;
    }

    for (int i = 0; i < count.length; i++) {
      sb.append((char)(i + 'a') + String.valueOf(count[i]));
    }

    return sb.toString();
  }
}

package com.zil.li.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by youlongli on 3/11/15.
 *
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {
  public int longestConsecutive(int[] num) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int res = 0;

    for (int i : num) {
      map.put(i, 0);
    }

    for (int i = 0; i < num.length; i++) {
      if (map.get(num[i]) == 0) {
        int currLen = 1;
        int l = num[i] - 1;
        int r = num[i] + 1;
        while (map.containsKey(l)) {
          map.put(l, 1);
          currLen++;
          l--;
        }
        while (map.containsKey(r)) {
          map.put(r, 1);
          currLen++;
          r++;
        }
        res = Math.max(res, currLen);
      }
    }

    return res;
  }
}

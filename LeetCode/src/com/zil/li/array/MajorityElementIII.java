package com.zil.li.array;

import java.util.*;

/**
 * Created by youlongli on 3/14/15.
 *
 * http://lintcode.com/en/problem/majority-number-iii/
 */
public class MajorityElementIII {
  public int majorityNumber(ArrayList<Integer> nums, int k) {
    // Key: element, Value: count, Size: Maximum K
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    for (int num : nums) {
      if (map.containsKey(num)) {
        map.put(num, map.get(num) + 1);
      } else {
        if (map.size() < k - 1) {
          map.put(num, 1);
        } else {
          List<Integer> removeKeys = new ArrayList<Integer>();
          for (int key : map.keySet()) {
            if (map.get(key) > 1) {
              map.put(key, map.get(key) - 1);
            } else {
              removeKeys.add(key);
            }
          }
          for (int key : removeKeys) {
            map.remove(key);
          }
        }
      }
    }

    for (int key : map.keySet()) {
      map.put(key, 0);
    }

    int res = 0;
    int count = 0;
    for (int num : nums) {
      if (map.containsKey(num)) {
        int val = map.get(num) + 1;
        if (count < val) {
          res = num;
          count = val;
        }
        map.put(num, val);
      }
    }

    return res;
  }
}

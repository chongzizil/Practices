package com.zil.li.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by youlongli on 3/14/15.
 *
 * http://lintcode.com/en/problem/subarray-sum/
 */
public class SubarraySum {
  // MLE...
  public ArrayList<Integer> solutionA(int[] nums) {
    // write your code here
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int sum = 0;

    map.put(0, -1); // Head
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (map.containsKey(sum)) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(map.get(sum) + 1);
        res.add(i);
        return res;
      } else {
        map.put(sum, i);
      }
    }

    throw new IllegalArgumentException("No solution");
  }
}

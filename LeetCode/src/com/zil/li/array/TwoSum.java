package com.zil.li.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by youlongli on 12/30/14.
 *
 * This is a easy one... No comment...
 */
public class TwoSum {
    public int[] solutionA(int[] numbers, int target) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < numbers.length; i++) {
        int numNeeded = target - numbers[i];
        if (map.containsKey(numNeeded)) {
          return new int[]{map.get(numNeeded) + 1, i + 1};
        } else {
          map.put(numbers[i], i);
        }
      }

      throw new IllegalArgumentException("No result...");
    }
}

package com.zil.li.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by youlongli on 12/30/14.
 *
 * This is a easy one... No comment...
 */
public class TwoSum {
  /**
   * Time complexity: O(n)
   * Space complexity: O(n)
   * Runtime: 245 ms
   */
  public int[] solutionA(int[] numbers, int target) {
    if (numbers == null || numbers.length < 2) {
      throw new IllegalArgumentException("No solution!");
    }

    Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // numNeed, index

    for (int i = 0; i < numbers.length; i++) {
      int numNeed = target - numbers[i];
      if (map.containsKey(numNeed)) {
        return new int[]{map.get(numNeed) + 1, i + 1};
      } else {
        map.put(numbers[i], i);
      }
    }

    throw new IllegalArgumentException("No solution!");
  }
}
package com.zil.li.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by youlongli on 2/17/15.
 *
 * https://oj.leetcode.com/problems/two-sum-iii-data-structure-design/
 */
public class TwoSumIII {
  private int[] array = new int[16];
  private int curr = 0;

  public void add(int number) {
    if (isFull()) {
      doubleSize();
    }

    array[curr++] = number;
  }

  public boolean find(int value) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    for (int i = 0; i < curr; i++) {
      int numNeed = value - array[i];
      if (map.containsKey(numNeed)) {
        return true;
      } else {
        map.put(array[i], i);
      }
    }

    return false;
  }

  private void doubleSize() {
    int[] newArray = new int[array.length * 2];
    for (int i = 0; i < array.length; i++) {
      newArray[i] = array[i];
    }
    array = newArray;
  }

  private boolean isFull() {
    return curr == array.length;
  }
}

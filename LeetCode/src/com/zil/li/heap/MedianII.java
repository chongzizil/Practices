package com.zil.li.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by youlongli on 3/15/15.
 *
 * http://lintcode.com/en/problem/median-ii/
 */
public class MedianII {
  public int[] medianII(int[] nums) {
    // write your code here
    PriorityQueue<Integer> minQ = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>() {
      public int compare(Integer i1, Integer i2) {
        return i2 - i1;
      }
    });

    int[] res = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      maxQ.offer(num);

      if (maxQ.size() - minQ.size() == 2) {
        minQ.offer(maxQ.poll());
      } else if (!minQ.isEmpty() && maxQ.peek() > minQ.peek()) {
        maxQ.offer(minQ.poll());
        minQ.offer(maxQ.poll());
      }

      res[i] = maxQ.peek();
    }

    return res;
  }
}

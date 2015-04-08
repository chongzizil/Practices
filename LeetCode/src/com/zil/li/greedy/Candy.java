package com.zil.li.greedy;

/**
 * Created by youlongli on 4/5/15.
 *
 * https://leetcode.com/problems/candy/
 */
public class Candy {
  public int candy(int[] ratings) {
    int sum = 0;
    int n = ratings.length;
    int[] candies = new int[n];

    // Left -> Right
    for (int i = 0; i < n; i++) {
      if (i != 0 && ratings[i] > ratings[i - 1]) {
        candies[i] = candies[i - 1] + 1;
      } else {
        candies[i] = 1;
      }
    }

    // Right -> Left
    for (int i = n - 1; i >= 0; i--) {
      if (i != n - 1 && ratings[i] > ratings[i + 1]) {
        candies[i] = Math.max(candies[i], candies[i + 1] + 1);
      }
      sum += candies[i];
    }

    return sum;
  }
}

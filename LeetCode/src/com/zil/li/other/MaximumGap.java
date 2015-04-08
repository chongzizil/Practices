package com.zil.li.other;

/**
 * Created by youlongli on 3/31/15.
 * <p>
 * Idea: use bucket sort...
 * <p>
 * https://leetcode.com/problems/maximum-gap/
 */
public class MaximumGap {
  class Bucket {
    int min;
    int max;

    public Bucket() {
      min = -1;
      max = -1;
    }
  }

  public int maximumGap(int[] num) {
    if (num == null || num.length < 2) {
      return 0;
    }

    int n = num.length;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      min = Math.min(min, num[i]);
      max = Math.max(max, num[i]);
    }

    int range = max - min;
    // interval * (min - min) = 0
    // interval * (max - min) = n
    double interval = (double) n / range;
    Bucket[] buckets = new Bucket[n + 1];

    for (int i = 0; i <= n; i++) {
      buckets[i] = new Bucket();
    }

    for (int i = 0; i < n; i++) {
      int val = num[i];
      int index = (int) (interval * (val - min));
      if (buckets[index].max == -1) {
        buckets[index].max = val;
        buckets[index].min = val;
      } else {
        buckets[index].max = Math.max(buckets[index].max, val);
        buckets[index].min = Math.min(buckets[index].min, val);
      }
    }

    int res = 0;
    int prev = buckets[0].max; // The first bucket must has at least one element
    for (int i = 1; i <= n; i++) {
      if (buckets[i].min != -1) { // The bucket is not empty
        res = Math.max(res, buckets[i].min - prev);
        prev = buckets[i].max;
      }
    }

    return res;
  }
}

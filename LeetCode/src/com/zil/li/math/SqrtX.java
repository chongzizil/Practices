package com.zil.li.math;

/**
 * Created by youlongli on 2/3/15.
 */
public class SqrtX {
  public int solutionA(int x) {
    if (x == 0 || x == 1) {
      return x;
    }

    int low = 1;
    int high = x;

    while (low + 1 < high) {
      int mid = low + (high - low) / 2;
      int tmp = x / mid;

      // Do not use (mid * mid < tmp) which might cause overflow!
      if (mid < tmp) {
        low = mid;
      } else if (mid > tmp) {
        high = mid;
      } else {
        return mid;
      }
    }

    return low;
  }

  public int solutionB(int x) {
    long low = 0;
    long high = x;

    while (low <= high) {
      long mid = low + (high - low) / 2;
//      long mid = (low + high) >>> 1;
      if (mid * mid > x) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return (int)high;
  }
}

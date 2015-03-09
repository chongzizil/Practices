package com.zil.li.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by youlongli on 3/7/15.
 *
 * https://oj.leetcode.com/problems/3sum/
 *
 * Gosh = .=, this problem has an awful title...
 */
public class ThreeSum {
  public List<List<Integer>> threeSum(int[] num) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    if (num == null || num.length < 3) {
      return res;
    }

    int n = num.length;

    Arrays.sort(num);

    for (int i = 0; i < n - 2; i++) {
      if (i != 0 && num[i] == num[i - 1]) {
        continue; // Skip duplicates
      }

      int l = i + 1;
      int r = n - 1;
      while (l < r) {
        int sum = num[i] + num[l] + num[r];
        if (sum == 0) {
          List<Integer> list = new ArrayList<Integer>();
          list.add(num[i]);
          list.add(num[l]);
          list.add(num[r]);
          res.add(list);
          l++;
          r--;
          while (l < r && num[l] == num[l - 1]) {
            l++; // Skip duplicates
          }
          while (l < r && num[r] == num[r + 1]) {
            r--; // Skip duplicates
          }
        } else if (sum < 0) {
          l++;
        } else {
          r--;
        }
      }
    }

    return res;
  }
}

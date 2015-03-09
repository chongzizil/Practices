package com.zil.li.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by youlongli on 3/7/15.
 *
 * https://oj.leetcode.com/problems/4sum/
 */
public class FourSum {
  public List<List<Integer>> fourSum(int[] num, int target) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    if (num == null || num.length < 4) {
      return res;
    }

    int n = num.length;
    Arrays.sort(num);

    for (int i = 0; i < n - 3; i++) {
      if (i != 0 && num[i] == num[i - 1]) {
        continue;
      }
      for (int j = i + 1; j < n - 2; j++) {
        if (j != i + 1 && num[j] == num[j - 1]) {
          continue;
        }

        int l = j + 1;
        int r = n - 1;
        while (l < r) {
          int sum = num[i] + num[j] + num[l] + num[r];
          if (sum == target) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(num[i]);
            list.add(num[j]);
            list.add(num[l]);
            list.add(num[r]);
            res.add(list);
            l++;
            r--;
            while (l < r && num[l] == num[l - 1]) {
              l++;
            }
            while (l < r && num[r] == num[r + 1]) {
              r--;
            }
          } else if (sum < target) {
            l++;
          } else {
            r--;
          }
        }
      }
    }

    return res;
  }
}

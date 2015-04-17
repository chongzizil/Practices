package com.zil.li.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by youlongli on 3/7/15.
 *
 * Other thoughts: Use map and store the sum of all paris, which transfer the problem into a two sum problem.
 *                 The issue and difficulties is how to handle duplicate results.
 *
 * https://oj.leetcode.com/problems/4sum/
 */
public class FourSum {
  /**
   * Time complexity: O(n^3) -> Sort takes O(nlogn) and triple for loop takes O(n^3)
   */
  public List<List<Integer>> fourSumA(int[] num, int target) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    if (num == null || num.length < 4) {
      return res;
    }

    int n = num.length;
    Arrays.sort(num);

    for (int i = 0; i < n - 3; i++) {
      if (i != 0 && num[i] == num[i - 1]) {
        continue; // Skip duplicates
      }
      for (int j = i + 1; j < n - 2; j++) {
        if (j != i + 1 && num[j] == num[j - 1]) {
          continue; // Skip duplicates
        }

        int l = j + 1;
        int r = n - 1;
        while (l < r) {
          int sum = num[i] + num[j] + num[l] + num[r];
          if (sum == target) { // Find one result
            List<Integer> list = new ArrayList<Integer>();
            list.add(num[i]);
            list.add(num[j]);
            list.add(num[l]);
            list.add(num[r]);
            res.add(list);

            // First move both pointers forward and than check duplicates
            l++;
            r--;
            while (l < r && num[l] == num[l - 1]) {
              l++; // Skip duplicates
            }
            while (l < r && num[r] == num[r + 1]) {
              r--; // Skip duplicates
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

  /**
   * This is a more general solution which actually is the solution for KSum problem.
   * Basic idea is still the same, trying to transfer it to a 2 sum problem via recursive (backtracking) function.
   *
   * Time complexity: O(n^3) -> Sort takes O(nlogn) and triple for loop takes O(n^3)
   */
  public List<List<Integer>> fourSumB(int[] num, int target) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    if (num == null || num.length < 4) {
      return res;
    }

    Arrays.sort(num);

    kSumHelper(res, list, num, target, 0, 4);

    return res;
  }

  private void kSumHelper(List<List<Integer>> res, List<Integer> list, int[] num, int target, int pos, int k) {
    int curr = list.size();
    // Lack of the corner case for k == 1 which is trivial though...
    if (list.size() == k - 2) {
      int l = pos;
      int r = num.length - 1;
      while (l < r) {
        int sum = num[l] + num[r];
        for (int i : list) {
          sum += i;
        }

        if (sum == target) {
          list.add(num[l]);
          list.add(num[r]);
          res.add(new ArrayList<Integer>(list));
          list.remove(list.size() - 1);
          list.remove(list.size() - 1);

          l++;
          r--;
          while(l < r && num[l] == num[l - 1]) l++;
          while(l < r && num[r] == num[r + 1]) r--;
        } else if (sum < target) {
          l++;
        } else if (sum > target) {
          r--;
        }
      }
    } else {
      for (int i = pos; i < num.length - k + 1 + curr; i++) {
        if (i != pos && num[i] == num[i - 1]) continue;

        list.add(num[i]);
        kSumHelper(res, list, num, target, i + 1, k);
        list.remove(list.size() - 1);
      }
    }
  }
}

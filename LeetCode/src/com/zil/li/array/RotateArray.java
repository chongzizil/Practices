package com.zil.li.array;

/**
 * Created by youlongli on 3/2/15.
 * <p>
 * https://oj.leetcode.com/problems/rotate-array/
 */
public class RotateArray {
  /**
   * Triple reverse, easy, in place and efficient.
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public void solutionA(int[] nums, int k) {
    int n = nums.length;

    k = k % n;

    reverse(nums, 0, n - k - 1);
    reverse(nums, n - k, n - 1);
    reverse(nums, 0, n - 1);
  }

  private void reverse(int[] nums, int beg, int end) {
    for (int i = beg, j = end; i < j; i++, j--) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
    }
  }

  /**
   * Time complexity: O(n)
   * Space complexity: O(n)
   */
  public void solutionB(int[] nums, int k) {
    int n = nums.length;
    k = k % n;
    int[] newArray = new int[n];

    for (int i = 0; i < k; i++) {
      newArray[i] = nums[i + n - k];
    }
    for (int i = k; i < n; i++) {
      newArray[i] = nums[i - k];
    }

    for (int i = 0; i < n; i++) {
      nums[i] = newArray[i];
    }
  }

  /**
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public void solutionC(int[] nums, int d) {
    for (int i = 0; i < getGCD(d, nums.length); i++) {
      int j = i;
      while (true) {
        int k = j + d;
        if (k >= nums.length) {
          k = k % nums.length;
        }
        if (k == i) {
          break;
        }
        swap(nums, i, k);
        j = k;
      }
    }
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  private int getGCD(int i, int j) {
    if (j == 0) {
      return i;
    } else {
      return getGCD(j, i % j);
    }
  }
}

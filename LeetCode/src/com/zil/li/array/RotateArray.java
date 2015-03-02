package com.zil.li.array;

/**
 * Created by youlongli on 3/2/15.
 */
public class RotateArray {
  /**
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public void solutionA(int[] nums, int k) {
    int n = nums.length;
    k = k % n;

    if (k == 0) {
      return;
    }

    int i = 0;
    int j = 0;
    int next = nums[0];
    int count = 0;
    while (count != nums.length) {
      j = (i + k) % n;
      int tmp = nums[j];
      nums[j] = next;
      next = tmp;
      i = j;
      count++;
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
}

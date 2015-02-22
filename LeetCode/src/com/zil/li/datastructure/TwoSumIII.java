package com.zil.li.datastructure;

/**
 * Created by youlongli on 2/17/15.
 */
public class TwoSumIII {
  private int[] nums = new int[8];
  int curr = 0;

  public void add(int number) {
    if (curr == nums.length) {
      doubleSize();
    }
    nums[curr] = number;
    curr++;
    sort();
  }

  public boolean find(int value) {
    int l = 0;
    int r = curr - 1;
    while (l < r) {
      int sum = nums[l] + nums[r];
      if (sum > value) {
        r--;
      } else if (sum < value) {
        l++;
      } else {
        return true;
      }
    }

    return false;
  }

  private void doubleSize() {
    int[] tmp = nums;
    nums = new int[curr * 2];
    for (int i = 0; i < tmp.length; i++) {
      nums[i] = tmp[i];
    }
  }

  private void sort() {
    quickSort(0, curr - 1);
  }

  private void quickSort(int l, int r) {
    int mid = l + (r - l) / 2;
    int i = l;
    int j = r;
    while (i <= j) {
      while (nums[i] < nums[mid]) {
        i++;
      }
      while (nums[j] > nums[mid]) {
        j--;
      }

      if (i <= j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        i++;
        j--;
      }
    }
    if (i < r) {
      quickSort(i, r);
    }
    if (j > l) {
      quickSort(l, j);
    }
  }
}

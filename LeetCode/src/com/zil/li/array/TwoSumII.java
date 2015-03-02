package com.zil.li.array;

/**
 * Created by youlongli on 12/30/14.
 *
 * https://oj.leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * This is a easy one... No comment...
 */
public class TwoSumII {
  /**
   * Binary search
   * Time complexity: O(nlogn)
   * Space complexity: O(1)
   */
  public int[] solutionA(int[] numbers, int target) {
    if (numbers == null || numbers.length < 2) {
      throw new IllegalArgumentException("No solution");
    }

    for (int i = 0; i < numbers.length; i++) {
      int possibleIndex = binarySearch(numbers, target - numbers[i], i + 1);
      if (possibleIndex != -1) {
        return new int[]{i + 1, possibleIndex + 1};
      }
    }

    throw new IllegalArgumentException("No solution");
  }

  public int binarySearch(int[] numbers, int key, int low) {
    int high = numbers.length - 1;

    while (low < high) {
      int mid = low + (high - low) / 2;
      int midElem = numbers[mid];
      if (midElem == key) {
        return mid;
      } else if (midElem > key) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return -1;
  }

  /**
   * Two pointers
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public int[] solutionB(int[] numbers, int target) {
    if (numbers == null || numbers.length < 2) {
      throw new IllegalArgumentException("No solution");
    }

    int l = 0;
    int r = numbers.length - 1;

    while (l < r) {
      int sum = numbers[l] + numbers[r];
      if (sum > target) {
        r--;
      } else if (sum < target) {
        l++;
      } else {
        return new int[]{l + 1, r + 1};
      }
    }

    throw new IllegalArgumentException("No solution");
  }
}

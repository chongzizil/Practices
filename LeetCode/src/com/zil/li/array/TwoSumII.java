package com.zil.li.array;

/**
 * Created by youlongli on 12/30/14.
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
    for (int i = 0; i < numbers.length; i++) {
      int possibleIndex = binarySearch(numbers, target - numbers[i], i + 1);
      if (possibleIndex != -1) {
        return new int[]{i + 1, possibleIndex + 1};
      }
    }

    throw new IllegalArgumentException("No result...");
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
    int low = 0;
    int high = numbers.length - 1;
    while (low < high) {
      int sum = numbers[low] + numbers[high];
      if (sum < target) {
        low++;
      } else if (sum > target) {
        high--;
      } else {
        return new int[]{low + 1, high + 1};
      }
    }

    throw new IllegalArgumentException("No result...");
  }
}

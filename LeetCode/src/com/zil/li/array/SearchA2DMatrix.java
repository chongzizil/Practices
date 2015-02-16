package com.zil.li.array;

/**
 * Created by youlongli on 2/3/15.
 */
public class SearchA2DMatrix {
  public boolean solutionA(int[][] matrix, int target) {
    int low = 0;
    int high = matrix.length - 1;
    int row = 0;

    if (target < matrix[0][0]) {
      return false;
    }

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (matrix[mid][0] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    row = high;
    low = 0;
    high = matrix[row].length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (matrix[row][mid] > target) {
        high = mid - 1;
      } else if (matrix[row][mid] < target) {
        low = mid + 1;
      } else {
        return true;
      }
    }

    return false;
  }

  // Half template...
  public boolean solutionB(int[][] matrix, int target) {
    int l = 0;
    int r = matrix.length - 1;
    int row = 0;

    if (target < matrix[0][0]) {
      return false;
    }

    while (l <= r) {
      int mid = l + (r - l) / 2;

      if (matrix[mid][0] > target) {
        r = mid - 1;
      } else if (matrix[mid][0] < target) {
        l = mid + 1;
      } else {
        return true;
      }
    }

    row = r;
    l = 0;
    r = matrix[0].length - 1;

    while (l + 1 < r) {
      int mid = l + (r - l) / 2;

      if (matrix[row][mid] > target) {
        r = mid;
      } else if (matrix[row][mid] < target) {
        l = mid;
      } else {
        return true;
      }
    }

    return matrix[row][l] == target || matrix[row][r] == target;
  }
}

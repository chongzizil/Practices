package com.zil.li.array;

/**
 * Created by youlongli on 3/2/15.
 *
 * https://oj.leetcode.com/problems/jump-game/
 */
public class JumpGame {
  /**
   * Greedy solution.
   * Always try to find the furthest position we can get to.
   */
  public boolean solutionA(int[] A) {
    int n = A.length;
    int furthest = A[0];

    for (int i = 1; i < n; i++) {
      // Note: remember to check i <= furthest where we can reach to position i.
      if (i <= furthest && i + A[i] > furthest) {
        furthest = i + A[i];
      }
    }

    return furthest >= n - 1;
  }

  /**
   * Greedy solution.
   * Always try to find the furthest position we can get to.
   */
  public boolean solutionB(int[] A) {
    int i = 0;
    int furthest = A[0];
    while (i < A.length && i <= furthest) {
      furthest = Math.max(furthest, A[i] + i);
      i++;
    }

    return furthest >= A.length - 1;
  }

  /**
   * DP solution which is TLE.
   */
  public boolean solutionC(int[] A) {
    int n = A.length;
    boolean[] can = new boolean[n];
    can[0] = true;

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (can[j] && j + A[j] >= i) {
          can[i] = true;
          break;
        }
      }
    }

    return can[n - 1];
  }
}

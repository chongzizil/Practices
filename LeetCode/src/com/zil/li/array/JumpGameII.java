package com.zil.li.array;

import java.util.Arrays;

/**
 * Created by youlongli on 3/2/15.
 *
 * https://oj.leetcode.com/problems/jump-game-ii/
 */
public class JumpGameII {
  /**
   * Greedy solution.
   * Each jump we try to find the furthest position, and start from the next of that position to
   * its longest jump position, we try again.
   */
  public int jump(int[] A) {
    int n = A.length;
    int beg = 0, end = 0, minJump = 0;

    while (end < n - 1) {
      minJump++;
      int furthest = end;
      for (int i = beg; i <= end; i++) {
        if (A[i] + i > furthest) {
          furthest = A[i] + i;
        }
      }
      beg = end + 1;
      end = furthest;
    }

    return minJump;
  }

  /**
   * DP solution which is TLE
   */
  public int solutionB(int[] A) {
    int n = A.length;
    int[] minJump = new int[n];
    Arrays.fill(minJump, Integer.MAX_VALUE);
    minJump[0] = 0;

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (minJump[j] != Integer.MAX_VALUE && j + A[j] >= i) {
          minJump[i] = minJump[i] + 1;
          break;
        }
      }
    }

    return minJump[n - 1];
  }
}

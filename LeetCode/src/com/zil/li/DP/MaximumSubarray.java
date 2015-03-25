package com.zil.li.DP;

/**
 * Created by youlongli on 2/22/15.
 *
 * https://oj.leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {
  public int solutionA(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }

    int res = Integer.MIN_VALUE;
    int sum = 0;

    for (int i = 0; i < A.length; i++) {
      sum += A[i];
      res = Math.max(res, sum);
      sum = Math.max(sum, 0);
    }

    return res;
  }

  /**
   * DP: dp_j is max_i(S_ij) which indicate the largest S_ij for a given i <= j.
   * Hence:
   * dp_0 = A[0]
   * dp_1 = A[0] + A[1], A[1] = dp_0 + A[1], A[1]
   * dp_2 = A[0] + A[1] + A[2], A[1] + A[2], A[2] = dp_1 + A[2], A[2]
   * ...
   */
  public int solutionB(int[] A) {
    int n = A.length;
    int[] dp = new int[n];

    dp[0] = A[0];
    for (int i = 1; i < n; i++) {
      dp[i] = Math.max(dp[i - 1] + A[i], A[i]);
    }

    int res = dp[0];
    for (int i = 1; i < n; i++) {
      res = Math.max(dp[i], res);
    }

    return res;
  }

  // Divide and conquer
  public int solutionC(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }

    return helper(A, 0, A.length - 1);
  }

  private int helper(int[] A, int l, int r) {
    if (l == r) {
      return A[l];
    }

    int mid = l + (r - l) / 2;
    int left = helper(A, l, mid);
    int right = helper(A, mid + 1, r);
    int leftCross = A[mid];
    int rightCross = A[mid + 1];
    int tmp = 0;
    for (int i = mid; i >= l; i--) {
      tmp += A[i];
      leftCross = Math.max(leftCross, tmp);
    }
    tmp = 0;
    for (int i = mid + 1; i <= r; i++) {
      tmp += A[i];
      rightCross = Math.max(rightCross, tmp);
    }

    return Math.max(leftCross + rightCross, Math.max(left, right));
  }
}

package com.zil.li.DP;

/**
 * Created by youlongli on 2/10/15.
 *
 * https://oj.leetcode.com/problems/unique-binary-search-trees/
 *
 * For more reference:
 * http://cs.lmu.edu/~ray/notes/binarytrees/
 * http://www.geeksforgeeks.org/program-nth-catalan-number/
 */
public class UniqueBinarySearchTrees {
  /**
   * O(n^2)
   * The idea:
   * If there's 0 node, then the head is null, there's 1 possibility.
   * If there's 1 node, then there's 0 node for its left and right subtree, so there's also 1 possibility.
   * If there's 2 node, then there's 1 node for its left and right subtree where left subtree may have 0 or 1 node. The total possibilities equals to the possibilities of left subtree multiply by the possibilities of right subtree.
   * so on and son on...
   */
  public int solutionA(int n) {
    int[] c = new int[n + 1];

    c[0] = 1;

    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        int l = j;
        int r = i - 1 - l;
        c[i] += c[l] * c[r];
      }
    }

    return c[n];
  }

  /**
   * O(n)
   * This solution use the equation directly:
   * C0 = 1 and Cn+1 = 2(2n + 1) / (n + 2) * Cn
   * Since all n and Cn are integers, be careful to the divide operation, which will cause bug!
   * The best solution is to deal with divide operator at last, since the result must be an integer.
   */
  public int solutionB(int n) {
    int[] c = new int[n + 1];

    c[0] = 1;

    for (int i = 1; i <= n; i++) {
      int x = i - 1;
      c[i] = (2 * (2 * x + 1) * c[x]) / (x + 2);
    }

    return c[n];
  }
}

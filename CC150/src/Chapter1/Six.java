package Chapter1;

import lib.AssortedMethods;

/**
 * Created by youlongli on 3/22/15.
 */
public class Six {
  public static void rotate(int[][] matrix) {
    int n = matrix.length;

    for (int k = 0; k < n / 2; k++) {
      // Fix: k & n - k - 1
      // Move: i & n - i - 1
      for (int i = k; i < n - k - 1; i++) { // top <-> right
        swap(matrix, k, i, i, n - k - 1);
      }
      for (int i = k; i < n - k - 1; i++) { // top <-> bottom
        swap(matrix, k, i, n - k - 1, n - i - 1);
      }
      for (int i = k; i < n - k - 1; i++) { // top <-> left
        swap(matrix, k, i, n - i - 1, k);
      }
    }
  }

  private static void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
    int tmp = matrix[i1][j1];
    matrix[i1][j1] = matrix[i2][j2];
    matrix[i2][j2] = tmp;
  }

  public static void main(String[] args) {
    int[][] matrix = AssortedMethods.randomMatrix(10, 10, 0, 9);
    AssortedMethods.printMatrix(matrix);
    rotate(matrix);
    System.out.println();
    AssortedMethods.printMatrix(matrix);
  }
}

package Chapter1;

import lib.AssortedMethods;

/**
 * Created by youlongli on 3/22/15.
 */
public class Seven {
  public static void setZeros(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    boolean firstRowZero = false;
    boolean firstColZero = false;

    for (int i = 0; i < n; i++) {
      if (matrix[0][i] == 0) {
        firstRowZero = true;
        break;
      }
    }

    for (int i = 0; i < m; i++) {
      if (matrix[i][0] == 0) {
        firstColZero = true;
        break;
      }
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    if (firstColZero) {
      for (int i = 0; i < m; i++) {
        matrix[i][0] = 0;
      }
    }

    if (firstRowZero) {
      for (int i = 0; i < n; i++) {
        matrix[0][i] = 0;
      }
    }
  }

  public static int[][] cloneMatrix(int[][] matrix) {
    int[][] c = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        c[i][j] = matrix[i][j];
      }
    }
    return c;
  }

  public static void main(String[] args) {
    int nrows = 10;
    int ncols = 15;
    int[][] matrix = AssortedMethods.randomMatrix(nrows, ncols, 0, 100);

    AssortedMethods.printMatrix(matrix);

    setZeros(matrix);

    System.out.println();

    AssortedMethods.printMatrix(matrix);
    System.out.println();
  }
}

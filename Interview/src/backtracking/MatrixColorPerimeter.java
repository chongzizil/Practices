package backtracking;

/**
 * Created by youlongli on 3/3/15.
 *
 * Given a matrix with different color for each cell and a start position,
 * found the perimeter of the shape with the same color as the start cell. (Only horizontally or vertically neighbor)
 */
public class MatrixColorPerimeter {
  private int res;
  public int getPerimeter(char[][] matrix, int row, int col) {
    res = 0;
    int m = matrix.length;
    int n = matrix[0].length;
    char color = matrix[row][col];
    boolean[][] visited = new boolean[m][n];

    helper(matrix, visited, color, row, col);

    return res;
  }

  private void helper (char[][] matrix, boolean[][] visited, char color, int i, int j) {
    int m = matrix.length;
    int n = matrix[0].length;
    if (i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] != color || visited[i][j]) {
      return;
    }

    // Update edges
    int add = 4;
    int sub = 0;
    if (i > 0 && visited[i - 1][j]) {
      add--;
      sub++;
    }
    if (i < m - 1 && visited[i + 1][j]) {
      add--;
      sub++;
    }
    if (j > 0 && visited[i][j - 1]) {
      add--;
      sub++;
    }
    if (j < n - 1 && visited[i][j + 1]) {
      add--;
      sub++;
    }
    res = res + add - sub;

    visited[i][j] = true;
    // Go DFS
    helper(matrix, visited, color, i - 1, j);
    helper(matrix, visited, color, i + 1, j);
    helper(matrix, visited, color, i, j - 1);
    helper(matrix, visited, color, i, j + 1);
  }
}

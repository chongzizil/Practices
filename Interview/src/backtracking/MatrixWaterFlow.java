package backtracking;

import com.sun.javafx.binding.StringFormatter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 3/4/15.
 *
 * Given a matrix where each cell contains a integer number representing the height of that cell.
 * Given a start position, check if the water can flow to both left/up and right/down side. Water can only
 * flow to a cell with same or lower height...
 */
public class MatrixWaterFlow {
  private boolean flowNW;
  private boolean flowSE;
  public boolean canFlow(int[][] matrix, int row, int col) {
    flowNW = false;
    flowSE = false;
    int m = matrix.length;
    int n = matrix[0].length;
    boolean[][] visited = new boolean[m][n];

    dfs(matrix, visited, row, col);

    return flowNW && flowSE;
  }

  private void dfs(int[][] matrix, boolean[][] visited, int i, int j) {
    int m = matrix.length;
    int n = matrix[0].length;

    // Bug, if the water flow along one of the side to both NW and SE, this codes will ignore them..
//    if (flowNW && flowSE) {
//      return;
//    }
    if (i == 0 || j == 0) {
      flowNW = true;
      return;
    }
    if (i == m - 1 || j == n - 1) {
      flowSE = true;
      return;
    }
    if (visited[i][j]) {
      return;
    }

    visited[i][j] = true;
    if (matrix[i][j] >= matrix[i - 1][j]) {
      dfs(matrix, visited, i - 1, j);
    }
    if (matrix[i][j] >= matrix[i + 1][j]) {
      dfs(matrix, visited, i + 1, j);
    }
    if (matrix[i][j] >= matrix[i][j - 1]) {
      dfs(matrix, visited, i, j - 1);
    }
    if (matrix[i][j] >= matrix[i][j + 1]) {
      dfs(matrix, visited, i, j + 1);
    }
  }

  public List<String>[] canFlowWithPath(int[][] matrix, int row, int col) {
    // 0: NW, 1: SE. If the size is 0 or 1, then it equals to false.
    List<String>[] res = new ArrayList[2];
    List<String> path = new ArrayList<>();
    int m = matrix.length;
    int n = matrix[0].length;
    boolean[][] visited = new boolean[m][n];

    dfsWithPath(res, path, matrix, visited, row, col);

    return res;
  }

  private void dfsWithPath(List<String>[] res, List<String> path, int[][] matrix, boolean[][] visited, int i, int j) {
    int m = matrix.length;
    int n = matrix[0].length;

    if (res[0] != null && res[1] != null) {
      return;
    }
    if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
      path.add(String.valueOf(i) + "," + String.valueOf(j));
      if (i == 0 || j == 0) {
        res[0] = new ArrayList<String>(path);
      } else {
        res[1] = new ArrayList<String>(path);
      }
      path.remove(path.size() - 1);
      return;
    }
    if (visited[i][j]) {
      return;
    }

    visited[i][j] = true;
    path.add(String.valueOf(i) + "," + String.valueOf(j));
    if (matrix[i][j] >= matrix[i - 1][j]) {
      dfsWithPath(res, path, matrix, visited, i - 1, j);
    }
    if (matrix[i][j] >= matrix[i + 1][j]) {
      dfsWithPath(res, path, matrix, visited, i + 1, j);
    }
    if (matrix[i][j] >= matrix[i][j - 1]) {
      dfsWithPath(res, path, matrix, visited, i, j - 1);
    }
    if (matrix[i][j] >= matrix[i][j + 1]) {
      dfsWithPath(res, path, matrix, visited, i, j + 1);
    }
    path.remove(path.size() - 1);
  }
}

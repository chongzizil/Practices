import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by youlongli on 4/11/15.
 */
public class SparseMatrix {
  private class Vector {
    // Key: Col index (0 based), Value: entry value
    Map<Integer, Double> vector;

    public Vector() {
      vector = new HashMap<>();
    }

    public void add(int col, double value) {
      vector.put(col, value);
    }

    public double get(int col) {
      return vector.get(col);
    }

    public boolean isZero(int col) {
      return !vector.containsKey(col);
    }

    public Set<Integer> indices() {
      return vector.keySet();
    }

    public double dot(double[] that) {
      double sum = 0.0;
      for (int i : vector.keySet()) {
        sum += that[i] * vector.get(i);
      }
      return sum;
    }
  }

  Map<Integer, Vector> matrix;
  int row;
  int col;

  public SparseMatrix() {
    matrix = new HashMap<>();
    // Row and Col index are only used for toString and only used is the matrix is constructed by passing in a two dimensional array matrix.
    this.row = -1;
    this.col = -1;
  }

  public SparseMatrix(double[][] matrix) {
    this.matrix = new HashMap<>();
    int row = matrix.length;
    int col = matrix[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (matrix[i][j] != 0) {
          add(i, j, matrix[i][j]);
        }
      }
    }

    this.row = row;
    this.col = col;
  }

  public void add(int row, int col, double value) {
    if (!matrix.containsKey(row)) {
      matrix.put(row, new Vector());
    }

    matrix.get(row).add(col, value);
  }

  public double get(int row, int col) {
    if (matrix.containsKey(row) && !matrix.get(row).isZero(col)) {
      return matrix.get(row).get(col);
    }
    return 0;
  }

  // Current functions only support NxN dot Nx1... (Need to implement functions to return a column for NxX dot NxN)
  public SparseMatrix dot(double[] that) {
    SparseMatrix newMatrix = new SparseMatrix();
    for (int i : matrix.keySet()) { // For each row
      newMatrix.add(i, 0, matrix.get(i).dot(that));
    }
    newMatrix.row = row;
    newMatrix.col = 1;
    return newMatrix;
  }

  @Override
  public String toString() {
    if (row == -1 || col == -1) {
      return "= .=... Sorry~";
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < row; i++) {
      sb.append("[");
      for (int j = 0; j < col; j++) {
        if (!matrix.containsKey(i) || matrix.get(i).isZero(j)) {
          sb.append(0);
        } else {
          sb.append(matrix.get(i).get(j));
        }
        sb.append(", ");
      }
      sb.setLength(sb.length() - 2); // Delete the last , and space
      sb.append("]\n");
    }

    return sb.toString();
  }
}

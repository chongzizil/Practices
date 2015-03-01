package com.zil.li.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 2/28/15.
 */
public class NQueens {
  public List<String[]> solveNQueens(int n) {
    List<String[]> res = new ArrayList<String[]>();
    if (n <= 0) {
      return res;
    }

    search(res, new ArrayList<Integer>(), n);
    return res;
  }

  private void search(List<String[]> res, List<Integer> cols, int n) {
    if (cols.size() == n) {
      res.add(drawChessBoard(cols));
      return;
    }

    for (int col = 0; col < n; col++) {
      if (isValid(cols, col)) {
        cols.add(col);
        search(res, cols, n);
        cols.remove(cols.size() - 1);
      }
    }
  }

  private String[] drawChessBoard(List<Integer> cols) {
    String[] chessboard = new String[cols.size()];
    for (int i = 0; i < cols.size(); i++) {
      chessboard[i] = "";
      for (int j = 0; j < cols.size(); j++) {
        if (j == cols.get(i)) {
          chessboard[i] += "Q";
        } else {
          chessboard[i] += ".";
        }
      }
    }

    return chessboard;
  }

  private boolean isValid(List<Integer> cols, int col) {
    int row = cols.size();
    for (int i = 0; i < row; i++) {
      // same column
      if (cols.get(i)== col)  {
        return false;
      }

      if (Math.abs(i - row) == Math.abs(cols.get(i) - col)) {
        return false;
      }
    }
    return true;
  }
}

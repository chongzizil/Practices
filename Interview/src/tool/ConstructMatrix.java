package tool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 3/4/15.
 * <p>
 * Simple code to generate matrix for testing... No error handling and etc....
 */
public class ConstructMatrix {
  public static int[][] generateIntMatrix(String str) {
    List<List<Integer>> matrixList = new ArrayList<>();
    String[] rows = str.split("\\n");

    for (int i = 0; i < rows.length; i++) {
      List<Integer> row = new ArrayList<>();
      String[] cells = rows[i].split("\\s");
      matrixList.add(row);

      try {
        for (int j = 0; j < cells.length; j++) {
          if (cells[j].equals("oo") || cells[j].equals("+oo")) {
            matrixList.get(i).add(Integer.MAX_VALUE);
          } else if (cells[j].equals("-oo")) {
            matrixList.get(i).add(Integer.MIN_VALUE);
          } else {
            matrixList.get(i).add(Integer.parseInt(cells[j]));
          }
        }
      } catch (NumberFormatException e) {
        return null; // Bad practice, just for convenience
      }
    }

    int[][] matrix = new int[matrixList.size()][matrixList.get(0).size()];

    for (int i = 0; i < matrixList.size(); i++) {
      for (int j = 0; j < matrixList.get(i).size(); j++) {
        matrix[i][j] = matrixList.get(i).get(j);
      }
    }

    return matrix;
  }

  public static char[][] generateCharMatrix(String str) {
    String[] lines = str.split("\\n");
    List<List<Character>> matrixList = new ArrayList<>();
    for (int i = 0; i < lines.length; i++) {
      List<Character> list = new ArrayList<>();
      String[] cells = lines[i].split("\\s");
      matrixList.add(list);

      for (int j = 0; j < cells.length; j++) {
        matrixList.get(i).add(cells[j].charAt(0));
      }
    }

    char[][] matrix = new char[matrixList.size()][matrixList.get(0).size()];

    for (int i = 0; i < matrixList.size(); i++) {
      for (int j = 0; j < matrixList.get(i).size(); j++) {
        matrix[i][j] = matrixList.get(i).get(j);
      }
    }

    return matrix;
  }
}

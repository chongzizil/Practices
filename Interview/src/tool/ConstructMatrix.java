package tool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 3/4/15.
 *
 * Simple code to generate matrix for testing... No error handling and etc....
 */
public class ConstructMatrix {
  public int[][] generateIntMatrix(String str) {
    String[] lines = str.split("\\n");
    List<List<Integer>> matrixList = new ArrayList<>();
    for (int i = 0; i < lines.length; i++) {
      List<Integer> list = new ArrayList<>();
      String[] cells = lines[i].split("\\s");
      matrixList.add(list);

      for (int j = 0; j < cells.length; j++) {
        matrixList.get(i).add(Integer.parseInt(cells[j]));
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

  public char[][] generateCharMatrix(String str) {
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

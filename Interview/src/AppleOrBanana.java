import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 4/3/15.
 *
 * Given a image matrix consisting of either 'B' or 'W'. Check whether the image is an apple or banana.
 *
 * Questions:
 * Is it filled?
 * What's the size of the matrix and how accurate/precise is the image...
 */
public class AppleOrBanana {
  public boolean isApple(char[][] image) {
    // Element: row * i + j
    List<Coordinate> boarders = new ArrayList<>();
    int row = image.length;
    int col = image[0].length;
    boolean[][] visited = new boolean[row][col];

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        dfs(boarders, image, visited, i, j);
      }
    }

    int minX = Integer.MAX_VALUE;
    int maxX = Integer.MIN_VALUE;
    int minY = Integer.MAX_VALUE;
    int maxY = Integer.MIN_VALUE;

    for (Coordinate coordinate : boarders) {
      minX = Math.min(minX, coordinate.x);
      maxX = Math.max(maxX, coordinate.x);
      minY = Math.min(minY, coordinate.y);
      maxY = Math.max(maxY, coordinate.y);
    }

    int n = Math.max(maxX - minX, maxY - minY);
    int sum = n * n;
    int sumBlack = 0;

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (image[i][j] == 'B') {
          sumBlack++;
        }
      }
    }

    return (double) sumBlack / sum > 0.5;
  }

  private class Coordinate {
    int x;
    int y;
    public Coordinate(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  private Coordinate findCenter(List<Coordinate> boarders) {
    int x = 0;
    int y = 0;
    int n = boarders.size();

    for (Coordinate coord : boarders) {
      x += coord.x;
      y += coord.y;
    }

    return new Coordinate(x / n, y / n);
  }

  private void dfs(List<Coordinate> boarders, char[][] image, boolean[][] visited, int i, int j) {
    int row = image.length;
    int col = image[0].length;

    if (i < 0 || j < 0 || i >= row || j >= col || visited[i][j] || image[i][j] == 'W') {
      return;
    }

    if (isBoarder(image, i, j)) {
      boarders.add(new Coordinate(i, j));
    }

    visited[i][j] = true;
    dfs(boarders, image, visited, i + 1, j);
    dfs(boarders, image, visited, i - 1, j);
    dfs(boarders, image, visited, i, j + 1);
    dfs(boarders, image, visited, i, j - 1);
  }

  private boolean isBoarder(char[][] image, int i, int j) {
    int row = image.length;
    int col = image[0].length;

    if ((i > 0 && image[i - 1][j] == 'W')
        || (i < row - 1 && image[i + 1][j] == 'W')
        || (j > 0 && image[i][j - 1] == 'W')
        || (j > col - 1 && image[i][j + 1] == 'W')) {
      return true;
    }

    return false;
  }
}

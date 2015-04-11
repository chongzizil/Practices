import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 3/30/15.
 */
public class Triangle {
  public static void main(String[] args) throws IOException {
    String test = "5\n" +
        "      9  6\n" +
        "    4   6  8\n" +
        "  0   7  1   5";
    List<List<Integer>> testTriangle = processStringInput(test);

    String file = "<Directory of the input file>";
    List<List<Integer>> triangle = processFileInput(file);

    // Solution description
    System.out.println("Solution A: Dynamic programming. (Top - Down)");
    System.out.println("Solution B: Dynamic programming. (Down - Top)");
    System.out.println("Solution C: Dynamic programming. (Recursive)");
    System.out.println("Solution D: Dynamic programming. (Memoization)");

    // Example online
    System.out.println("Start simple test triangle: ");
    System.out.println("Solution A: " + solutionA(testTriangle));
    System.out.println("Solution B: " + solutionB(testTriangle));
    System.out.println("Solution C: " + solutionC(testTriangle));
    System.out.println("Solution D: " + solutionD(testTriangle));

    // triangle.txt
    System.out.println("Start large triangle: ");
    System.out.println("Solution A: " + solutionA(triangle));
    System.out.println("Solution B: " + solutionB(triangle));
    // Simple recursive solution's performance is horrible since it does a lot of repeated calculation.
//    System.out.println("Solution C: " + solutionC(triangle));
    System.out.println("Solution D: " + solutionD(triangle));
  }

  /**
   * Simple triangle generate function which accepts the input file's directory and file name as a single String.
   */
  private static List<List<Integer>> processFileInput(String file) throws IOException {
    List<List<Integer>> triangle = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = br.readLine()) != null) {
        triangle.add(processLine(line));
      }
    }

    return triangle;
  }

  /**
   * Simple triangle generate function which accepts the input as a String where each line is a level and each number is separated by spaces.
   */
  private static List<List<Integer>> processStringInput(String input) {
    List<List<Integer>> triangle = new ArrayList<>();
    String[] lines = input.split("\n");
    for (String line : lines) {
      triangle.add(processLine(line));
    }
    return triangle;
  }

  /**
   * Simple function which accepts a String as a level of numbers.
   */
  private static List<Integer> processLine(String line) {
    List<Integer> level = new ArrayList<>();
    line = line.trim();
    String[] numbers = line.split("\\s+");
    for (String number : numbers) {
      level.add(Integer.parseInt(number));
    }
    return level;
  }

  /**
   * Dynamic programming. (Top - Down)
   */
  private static int solutionA(List<List<Integer>> triangle) {
    if (triangle == null || triangle.size() == 0) {
      return 0;
    }

    int res = 0;
    int n = triangle.size();
    int[][] dp = new int[n][n];

    dp[0][0] = triangle.get(0).get(0);
    for (int i = 1; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        if (j == 0) { // Special case for leftmost element
          dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
        } else if (j == i) { // Special case for rightmost element
          dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
        } else { // General cases
          dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
        }
      }
    }

    for (int i = 0; i < n; i++) {
      res = Math.max(res, dp[n - 1][i]);
    }

    return res;
  }

  /**
   * Dynamic programming. (Down - Top)
   */
  private static int solutionB(List<List<Integer>> triangle) {
    if (triangle == null || triangle.size() == 0) {
      return -1;
    }

    int n = triangle.size();
    int[][] dp = new int[n][n];

    for (int i = n - 1; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        if (i == n - 1) { // Base case
          dp[i][j] = triangle.get(i).get(j);
        } else {
          dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
        }
      }
    }

    return dp[0][0];
  }

  /**
   * Recursive
   */
  private static int solutionC(List<List<Integer>> triangle) {
    return solutionCHelper(triangle, 0, 0, 0);
  }

  private static int solutionCHelper(List<List<Integer>> triangle, int sum, int i, int j) {
    // Base case
    if (i == triangle.size() - 1) {
      return triangle.get(i).get(j);
    }

    return Math.max(solutionCHelper(triangle, sum, i + 1, j), solutionCHelper(triangle, sum, i + 1, j + 1)) + triangle.get(i).get(j);
  }

  /**
   * Memoization
   */
  private static int solutionD(List<List<Integer>> triangle) {
    int n = triangle.size();
    int[][] mem = new int[n][n]; // look-up table

    // Initialize
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == n - 1) {
          mem[i][j] = triangle.get(i).get(j);
        } else {
          mem[i][j] = Integer.MIN_VALUE;
        }
      }
    }

    return solutionDHelper(triangle, mem, 0, 0);
  }

  private static int solutionDHelper(List<List<Integer>> triangle, int[][] mem, int i, int j) {
    // Base case
    if (mem[i][j] != Integer.MIN_VALUE) {
      return mem[i][j];
    }

    int leftMax = solutionDHelper(triangle, mem, i + 1, j);
    int rightMax = solutionDHelper(triangle, mem, i + 1, j + 1);
    mem[i][j] = Math.max(leftMax, rightMax) + triangle.get(i).get(j);
    return mem[i][j];
  }
}

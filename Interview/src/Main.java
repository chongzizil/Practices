import tool.ConstructMatrix;

/**
 * Created by youlongli on 3/4/15.
 */
public class Main {
  public static void main(String[] args) {
    String test1 = "r r r r r\n" +
        "r g g g r\n" +
        "r g g g r\n" +
        "r g g g r\n" +
        "r r r r r";

    String test2 = "1 1 1 1 1\n" +
        "1 0 0 0 1\n" +
        "1 0 0 0 1\n" +
        "1 0 0 0 1\n" +
        "1 1 1 1 1";

    ConstructMatrix constructMatrix = new ConstructMatrix();
    char[][] res1 = constructMatrix.generateCharMatrix(test1);
    int[][] res2 = constructMatrix.generateIntMatrix(test2);
    int i = 0;
  }
}

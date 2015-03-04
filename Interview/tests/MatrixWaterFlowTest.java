import junit.framework.TestCase;
import org.junit.Test;
import tool.ConstructMatrix;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class MatrixWaterFlowTest extends TestCase {
  MatrixWaterFlow matrixWaterFlow = new MatrixWaterFlow();
  ConstructMatrix constructMatrix = new ConstructMatrix();

  @Test
  public void testCanFlow() throws Exception {
    String matrixStr = "4 4 1 4 4\n" +
        "4 2 2 2 4\n" +
        "4 2 3 2 4\n" +
        "4 2 2 2 4\n" +
        "4 4 1 4 4";
    int[][] matrix = constructMatrix.generateIntMatrix(matrixStr);

    assertEquals(matrixWaterFlow.canFlow(matrix, 2, 2), true);
  }

  @Test
  public void testCanFlowOnlyNW() throws Exception {
    String matrixStr = "4 4 1 4 4\n" +
        "4 2 2 2 4\n" +
        "4 2 3 2 4\n" +
        "4 2 2 2 4\n" +
        "4 4 4 4 4";
    int[][] matrix = constructMatrix.generateIntMatrix(matrixStr);

    assertEquals(matrixWaterFlow.canFlow(matrix, 2, 2), false);
  }

  @Test
  public void testCanFlowMediumMatrix() throws Exception {
    String matrixStr = "1 0 8 8 0 0 0 10 10 10\n" +
        "1 0 0 9 10 10 10 7 6 6\n" +
        "1 2 1 9 8 8 7 7 10 5\n" +
        "1 3 2 10 8 11 11 11 5 5\n" +
        "1 3 2 10 9 10 10 12 4 8\n" +
        "1 3 2 9 8 11 11 11 4 3\n" +
        "1 4 3 8 7 6 6 7 8 3\n" +
        "1 4 3 8 8 8 5 6 2 2\n" +
        "1 5 4 4 4 5 5 6 1 9\n" +
        "1 5 5 5 5 6 6 6 0 9";
    int[][] matrix = constructMatrix.generateIntMatrix(matrixStr);

    assertEquals(matrixWaterFlow.canFlow(matrix, 3, 5), true);
  }

  @Test  public void testCanFlowMediumMatrixPath() throws Exception {
    String matrixStr = "4 4 1 4 4\n" +
        "4 2 2 2 4\n" +
        "4 2 3 2 4\n" +
        "4 2 2 2 4\n" +
        "4 4 1 4 4";
    int[][] matrix = constructMatrix.generateIntMatrix(matrixStr);

    List<String>[] path = matrixWaterFlow.canFlowWithPath(matrix, 2, 2);
    /**
     * TODO: If there's multiple path, this solution will only return one of them, not necessarily the shortest one.
     * In order to find the shortest one, bfs will be a much efficient solution :)
     */
  }
}
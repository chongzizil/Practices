import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SparseMatrixTest {
  SparseMatrix sparseMatrix;
  double[][] matrix;

  @Before
  public void setUp() throws Exception {
    matrix = new double[5][5];
    matrix[0] = new double[]{1,0,0,0,0};
    matrix[1] = new double[]{0,2,0,0,0};
    matrix[2] = new double[]{0,0,3,0,0};
    matrix[3] = new double[]{0,0,0,4,0};
    matrix[4] = new double[]{0,0,0,0,5};

    sparseMatrix = new SparseMatrix(matrix);
  }

  @Test
  public void smallTest() throws Exception {
    System.out.println(sparseMatrix.toString());
    SparseMatrix newMatrix = sparseMatrix.dot(new double[]{2, 2, 2, 2, 2});
    System.out.println(newMatrix.toString());
  }
}
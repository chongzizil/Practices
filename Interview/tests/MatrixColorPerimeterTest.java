import backtracking.MatrixColorPerimeter;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatrixColorPerimeterTest extends TestCase {
  MatrixColorPerimeter matrixColorPerimeter = new MatrixColorPerimeter();
  char[][] matrixSmall;
  char[][] matrix;

  /**
   * r r r r r r
   * r r g g r r
   * r g g g g r
   * r g g g g r
   * r r g g r r
   * r r r r r r
   */
  @Before
  public void setUp() {
    matrix = new char[6][6];
    matrix[0][0] = 'r';
    matrix[0][1] = 'r';
    matrix[0][2] = 'r';
    matrix[0][3] = 'r';
    matrix[0][4] = 'r';
    matrix[0][5] = 'r';

    matrix[1][0] = 'r';
    matrix[1][1] = 'r';
    matrix[1][2] = 'g';
    matrix[1][3] = 'g';
    matrix[1][4] = 'r';
    matrix[1][5] = 'r';

    matrix[2][0] = 'r';
    matrix[2][1] = 'g';
    matrix[2][2] = 'g';
    matrix[2][3] = 'g';
    matrix[2][4] = 'g';
    matrix[2][5] = 'r';

    matrix[3][0] = 'r';
    matrix[3][1] = 'g';
    matrix[3][2] = 'g';
    matrix[3][3] = 'g';
    matrix[3][4] = 'g';
    matrix[3][5] = 'r';

    matrix[4][0] = 'r';
    matrix[4][1] = 'r';
    matrix[4][2] = 'g';
    matrix[4][3] = 'g';
    matrix[4][4] = 'r';
    matrix[4][5] = 'r';

    matrix[5][0] = 'r';
    matrix[5][1] = 'r';
    matrix[5][2] = 'r';
    matrix[5][3] = 'r';
    matrix[5][4] = 'r';
    matrix[5][5] = 'r';

    matrixSmall = new char[3][3];
    matrixSmall[0][0] = 'r';
    matrixSmall[0][1] = 'r';
    matrixSmall[0][2] = 'r';

//    matrixSmall[1][0] = 'r';
//    matrixSmall[1][1] = 'g';
//    matrixSmall[1][2] = 'r';
//
//    matrixSmall[2][0] = 'r';
//    matrixSmall[2][1] = 'r';
//    matrixSmall[2][2] = 'r';
  }

  @Test
  public void testGetPerimeter() throws Exception {
    assertEquals(16, matrixColorPerimeter.getPerimeter(matrix, 2, 2));
    assertEquals(40, matrixColorPerimeter.getPerimeter(matrix, 1, 1));
    assertEquals(8, matrixColorPerimeter.getPerimeter(matrixSmall, 0, 0));
  }
}
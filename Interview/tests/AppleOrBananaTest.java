import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tool.ConstructMatrix;

import static org.junit.Assert.*;

public class AppleOrBananaTest {
  AppleOrBanana appleOrBanana = new AppleOrBanana();
  char[][] apple;
  char[][] bananaHor;
  char[][] bananaVer;
  char[][] bananaDia;

  @Before
  public void setUp() throws Exception {
    String appleStr =
        "W W W W W W W W W W W W W W W\n" +
        "W W W W W W W W W W W W W W W\n" +
        "W W W W W W W W B W W W W W W\n" +
        "W W W W W W W B W W W W W W W\n" +
        "W W W W B B W B W B B W W W W\n" +
        "W W W B B B B B B B B B W W W\n" +
        "W W B B B B B B B B B B B W W\n" +
        "W W B B B B B B B B B B B W W\n" +
        "W W B B B B B B B B B B B W W\n" +
        "W W B B B B B B B B B B B W W\n" +
        "W W B B B B B B B B B B B W W\n" +
        "W W W B B B B B B B B B W W W\n" +
        "W W W W B B B B B B B W W W W\n" +
        "W W W W W B B B B B W W W W W\n" +
        "W W W W W W W W W W W W W W W";
    String bananaStrHor =
        "W W W W W W W W W W W W W W W\n" +
        "W W W W W W W W W W W W W W W\n" +
        "W W W W W W W W W W W W W W W\n" +
        "W W W W W W W W W W W W W W W\n" +
        "W W W W W W W W W W W W W W W\n" +
        "W B B W W W W W W W W W B B W\n" +
        "W B B B W W W W W W W B B B W\n" +
        "W W B B B B W W W B B B B W W\n" +
        "W W W B B B B B B B B B W W W\n" +
        "W W W W W B B B B B W W W W W\n" +
        "W W W W W W W W W W W W W W W\n" +
        "W W W W W W W W W W W W W W W\n" +
        "W W W W W W W W W W W W W W W\n" +
        "W W W W W W W W W W W W W W W\n" +
        "W W W W W W W W W W W W W W W";
    String bananaStrVer =
        "W W W W W W W W W W W W W W W\n" +
        "W W W W W W B B W W W W W W W\n" +
        "W W W W W B B B W W W W W W W\n" +
        "W W W W B B B W W W W W W W W\n" +
        "W W W W B B W W W W W W W W W\n" +
        "W W W B B B W W W W W W W W W\n" +
        "W W W B B W W W W W W W W W W\n" +
        "W W W B B W W W W W W W W W W\n" +
        "W W W B B W W W W W W W W W W\n" +
        "W W W B B B W W W W W W W W W\n" +
        "W W W W B B W W W W W W W W W\n" +
        "W W W W B B B W W W W W W W W\n" +
        "W W W W W B B B W W W W W W W\n" +
        "W W W W W W B B W W W W W W W\n" +
        "W W W W W W W W W W W W W W W\n";
    String bananaStrDia =
        "W W W W W W W W W W W W W W W\n" +
        "W W W W W W W W W W W W W W W\n" +
        "W W W W W W W W W W W W W W W\n" +
        "W W W W W W W W W W W W W W W\n" +
        "W W B W W W W W W W W W W W W\n" +
        "W W B B W W W W W W W W W W W\n" +
        "W W B B B W W W W W W W W W W\n" +
        "W W W B B W W W W W W W W W W\n" +
        "W W W B B B W W W W W W W W W\n" +
        "W W W W B B B W W W W W W W W\n" +
        "W W W W W B B B B W W W W W W\n" +
        "W W W W W W W B B B B W W W W\n" +
        "W W W W W W W W W B B B W W W\n" +
        "W W W W W W W W W W W W W W W\n" +
        "W W W W W W W W W W W W W W W";
    apple = ConstructMatrix.generateCharMatrix(appleStr);
    bananaHor = ConstructMatrix.generateCharMatrix(bananaStrHor);
    bananaDia = ConstructMatrix.generateCharMatrix(bananaStrDia);
    bananaVer = ConstructMatrix.generateCharMatrix(bananaStrVer);
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testIsApple() throws Exception {
    assertEquals(true, appleOrBanana.isApple(apple));
    assertEquals(false, appleOrBanana.isApple(bananaHor));
    assertEquals(false, appleOrBanana.isApple(bananaDia));
    assertEquals(false, appleOrBanana.isApple(bananaVer));
  }
}
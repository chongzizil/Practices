import org.junit.Test;

import static org.junit.Assert.*;

public class EvalArithmeticStrTest {
  EvalArithmeticStr evalArithmeticStr = new EvalArithmeticStr();

  @Test
  public void testSolutionOnlyAddition() throws Exception {
    String expr = "1+2+3+4";
    assertEquals(10, evalArithmeticStr.solution(expr));
  }

  public void testSolutionOnlyAdditionAndParenthesis() throws Exception {
    String expr = "1+(2+3)+4";
    assertEquals(10, evalArithmeticStr.solution(expr));
  }

  @Test
  public void testSolutionWithMultiplication() throws Exception {
    String expr = "1+2*3+4";
    assertEquals(11, evalArithmeticStr.solution(expr));
  }

  @Test
  public void testSolutionWithMultiplicationAndParenthesis() throws Exception {
    String expr = "1+2*(3+4)+1";
    assertEquals(16, evalArithmeticStr.solution(expr));
  }

  @Test
  public void testSolutionWithUnary() throws Exception {
    String expr = "1+-2*3++4";
    assertEquals(-1, evalArithmeticStr.solution(expr));
  }

  @Test
  public void testSolutionComplicate1() throws Exception {
    String expr = "-1--2++2*3+10/-5--1";
    assertEquals(6, evalArithmeticStr.solution(expr));
  }

  @Test
  public void testSolutionComplicate2() throws Exception {
    String expr = "-1--2++6-2--1";
    assertEquals(6, evalArithmeticStr.solution(expr));
  }

  @Test
  public void testSolutionComplicateAndParenthesis() throws Exception {
    String expr = "1+(+2)";
    assertEquals(3, evalArithmeticStr.solution(expr));
  }
}
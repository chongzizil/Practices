import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseStrWithPunctuationTest {
  ReverseStrWithPunctuation test = new ReverseStrWithPunctuation();

  @Test
  public void testReverseStrWithPunctuation() throws Exception {
    String str1 = "This is a simple example";
    String expectedStr1 = "example simple a is This";
    assertEquals(expectedStr1, test.reverseStrWithPunctuation(str1));

    String str2 = "This - is. a .simple example?";
    String expectedStr2 = "example - simple. a .is This?";
    assertEquals(expectedStr2, test.reverseStrWithPunctuation(str2));
  }
}
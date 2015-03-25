import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PalindromePermutationTest {
  PalindromePermutation palindromePermutation = new PalindromePermutation();

  @Test
  public void testCanBePalindrome() throws Exception {
    assertEquals(palindromePermutation.canBePalindrome("qweasdzxcqweasdzxc"), true);
  }

  @Test
  public void testGetPalindromePermutation() throws Exception {
    List<String> res = palindromePermutation.getPalindromePermutation("aabbc");
    List<String> expect = new ArrayList<String>();
    // Simple test... Does not scale.
    expect.add("abcba");
    expect.add("bacab");
    assertEquals(res.equals(expect), true);
  }
}
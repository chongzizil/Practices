import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {
  Trie trie;
  String[] dict;

  @Before
  public void setUp() throws Exception {
    trie = new Trie();
    dict = new String[]{"google", "goo", "yahoo", "facebook", "LinkedIn", "Amazon"}; // :)
    for (String word : dict) {
      trie.add(word.toLowerCase());
    }
  }

  @Test
  public void simpleTest() throws Exception {
    assertEquals(true, trie.contains("google"));
    assertEquals(true, trie.contains("goo"));
    assertEquals(true, trie.contains("yahoo"));
    assertEquals(true, trie.contains("facebook"));
    assertEquals(true, trie.contains("LinkedIn".toLowerCase()));
    assertEquals(true, trie.contains("Amazon".toLowerCase()));
  }

  @Test
  public void simpleTest2() throws Exception {
    assertEquals(true, trie.isPrefix("go"));
    assertEquals(true, trie.isPrefix("goo"));
    assertEquals(true, trie.isPrefix("goog"));
    assertEquals(false, trie.isPrefix("goa"));
  }
}
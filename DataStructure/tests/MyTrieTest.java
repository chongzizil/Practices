import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyTrieTest {
  MyTrie trie;
  String[] dict;

  @Before
  public void setUp() throws Exception {
    trie = new MyTrie();
    dict = new String[]{"google", "goo", "yahoo", "facebook", "LinkedIn", "Amazon"}; // :)
    for (String word : dict) {
      trie.add(word);
    }
  }

  @Test
  public void simpleTest() throws Exception {
    assertEquals(true, trie.contains("google"));
    assertEquals(true, trie.contains("goo"));
    assertEquals(true, trie.contains("yahoo"));
    assertEquals(true, trie.contains("facebook"));
    assertEquals(true, trie.contains("LinkedIn"));
    assertEquals(true, trie.contains("Amazon"));
  }

  @Test
  public void simpleTest2() throws Exception {
    assertEquals(true, trie.isPrefix("go"));
    assertEquals(true, trie.isPrefix("goo"));
    assertEquals(true, trie.isPrefix("goog"));
    assertEquals(false, trie.isPrefix("goa"));
  }
}
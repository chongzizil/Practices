import java.util.Collection;

/**
 * Created by youlongli on 3/2/15.
 *
 * This is a simple implementation of trie without error check and exception handling.
 */
public class Trie {
  class TrieNode {
    private int numChildren = 0;
    private boolean isWord = false;

    private TrieNode[] children;

    public TrieNode() {
      this.numChildren = 0;
      this.isWord = false;
      this.children = new TrieNode[26];
    }
  }

  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public Trie(Collection<String> words) {
    addAll(words);
  }

  public void addAll(Collection<String> words) {
    for (String word : words) {
      add(word);
    }
  }

  public void add(String s) {
    TrieNode curr = root;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int index = c - 'a';
      if (curr.children[index] == null) {
        curr.children[index] = new TrieNode();
      }
      curr.numChildren++;
      curr = curr.children[index];
    }

    curr.isWord = true;
  }

  private TrieNode getNode(String s) {
    TrieNode curr = root;
    for (int i = 0; i < s.length(); i++) {
      int index = s.charAt(i) - 'a';
      curr = curr.children[index];
      if (curr == null) {
        return null;
      }
    }
    return curr;
  }

  public boolean contains(String s) {
    TrieNode node = getNode(s);
    return node != null && node.isWord;
  }

  public boolean isPrefix(String s) {
    TrieNode node = getNode(s);
    return node != null && node.numChildren > 0;
  }
}

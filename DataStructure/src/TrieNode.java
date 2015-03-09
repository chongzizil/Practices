import java.util.Collection;

/**
 * Created by youlongli on 3/2/15.
 *
 * This is a simple implementation of trie without error check and exception handling.
 */
public class TrieNode {
  public int numChildren = 0;
  public boolean isWord = false;

  private TrieNode[] children = new TrieNode[26];

  public TrieNode() {
  }

  public TrieNode(Collection<String> words) {
    for (String word : words) {
      add(word);
    }
  }

  public boolean add(String s) {
    TrieNode curr = this;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int index = c - 'a';
      if (curr.children[index] == null) {
        curr.children[index] = new TrieNode();
      }
      curr.numChildren++;
      curr = curr.children[index];
    }

    if (curr.isWord) {
      return false;
    } else {
      curr.isWord = true;
      return true;
    }
  }

  public TrieNode getNextNode(char c) {
    int index = c - 'a';
    return children[index];
  }

  public TrieNode getNode(String s) {
    TrieNode curr = this;
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

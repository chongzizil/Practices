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
    char first = s.charAt(0);
    int index = first - 'a';
    TrieNode child = children[index];
    if (child == null) {
      child = new TrieNode();
      children[index] = child;
      numChildren++;
    }
    if (s.length() == 1) {
      if (child.isWord) {
        return false;
      }
      child.isWord = true;
      return true;
    } else {
      return child.add(s.substring(1));
    }
  }

  public TrieNode getNextNode(char c) {
    int index = c - 'a';
    return children[index];
  }

  public TrieNode getNode(String s) {
    TrieNode node = this;
    for (int i = 0; i < s.length(); i++) {
      int index = s.charAt(i) - 1;
      TrieNode child = node.children[index];
      if (child == null) {
        return null;
      }
      node = child;
    }
    return node;
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

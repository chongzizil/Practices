/**
 * Created by youlongli on 4/17/15.
 */
public class MyTrie {
  private class TrieNode {
    boolean isWord;
    int numChildren;
    TrieNode[] children;

    public TrieNode() {
      children = new TrieNode[26];
    }
  }

  TrieNode head;

  public MyTrie() {
    this.head = new TrieNode();
  }

  public void add(String s) {
    s = s.toLowerCase();

    TrieNode node = head;
    for (int i = 0; i < s.length(); i++) {
      int index = s.charAt(i) - 'a';
      if (node.children[index] == null) {
        node.children[index] = new TrieNode();
      }
      node.numChildren++;
      node = node.children[index];
    }
    node.isWord = true;
  }

  public boolean contains(String s) {
    TrieNode node = getNode(s);
    return node != null && node.isWord;
  }

  public boolean isPrefix(String s) {
    TrieNode node = getNode(s);
    return node != null && node.numChildren > 0;
  }

  private TrieNode getNode(String s) {
    s = s.toLowerCase();

    TrieNode node = head;
    for (int i = 0; i < s.length(); i++) {
      int index = s.charAt(i) - 'a';
      if (node.children[index] == null) {
        return null;
      }
      node = node.children[index];
    }

    return node;
  }
}

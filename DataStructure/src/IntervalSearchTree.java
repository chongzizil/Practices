import datastructure.Interval;

/**
 * Created by youlongli on 4/11/15.
 *
 * Normally, Red-Black tree or AVL tree should be implemented...
 * For simplicity, only simple BST insert is implemented...
 */
public class IntervalSearchTree {
  private class Node {
    Interval interval;
    int max; // Max endpoint in subtree rooted at node
    Node left;
    Node right;

    public Node(Interval interval) {
      this.interval = interval;
      this.max = interval.getEnd();
      left = null;
      right = null;
    }

    @Override
    public String toString() {
      return interval.toString() + " max = " + max;
    }
  }

  Node root;

  public IntervalSearchTree() {
    this.root = null;
  }

  public void insert(Interval interval) {
    root = insert(root, interval);
  }

  private Node insert(Node root, Interval interval) {
    if (root == null) {
      return getNewNode(interval);
    }

    int beg = root.interval.getBeg();

    if (interval.getBeg() < beg) {
      root.left = insert(root.left, interval);
    } else {
      root.right = insert(root.right, interval);
    }

    if (root.max < interval.getEnd()) {
      root.max = interval.getEnd();
    }

    return root;
  }

  private Node getNewNode(Interval interval) {
    return new Node(interval);
  }

  public Interval searchOverlap(Interval interval) {
    return searchOverlap(root, interval);
  }

  public Interval searchOverlap(Node root, Interval interval) {
    if (root == null) {
      return null;
    }

    if (root.interval.doOverlap(interval)) {
      return root.interval;
    }

    if (root.left != null && root.left.max >= interval.getBeg()) {
      return searchOverlap(root.left, interval);
    }

    return searchOverlap(root.right, interval);
  }

  public void inorderPrint() {
    inorderPrint(root);
  }

  public void inorderPrint(Node root) {
    if (root == null) return;

    inorderPrint(root.left);
    System.out.println(root.toString());
    inorderPrint(root.right);
  }
}

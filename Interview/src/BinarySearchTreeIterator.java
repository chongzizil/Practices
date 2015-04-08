import datastructure.TreeNode;

import java.util.NoSuchElementException;

/**
 * Created by youlongli on 4/5/15.
 *
 * https://leetcode.com/problems/binary-search-tree-iterator/
 *
 * Follow up: Can use only O(1) space, but the node will contains its parent node.
 *
 * Idea: Since it's inorder traversal, so if a node has a left node, then move to the left node first.
 *       Otherwise we process the node itself and try to move to its right child end right child's left most.
 *       The important part is when the child node finishes, we need to check the whether the child is a left child or a right child.
 *       For left child, it means current node is not processed.
 *       For right child, it means current node is processed, so we need to move up until the node is not process or null which indicates we finish all nodes...
 */
public class BinarySearchTreeIterator {
  TreeNode nextNode;

  public BinarySearchTreeIterator(TreeNode root) {
    if (root != null) {
      nextNode = root;
    }

    while (nextNode.left != null) {
      nextNode = nextNode.left;
    }
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return nextNode != null;
  }

  /** @return the next smallest number */
  public int next() {
    if (nextNode == null) {
      throw new NoSuchElementException("");
    }

    int val = nextNode.val;

    if (nextNode.right != null) {
      nextNode = nextNode.right;
      while (nextNode.left != null) {
        nextNode = nextNode.left;
      }
    } else {
      TreeNode parent = nextNode.parent;
      TreeNode child = nextNode;
      while(parent != null && parent.right == child) {
        child = parent;
        parent = child.parent;
      }
      nextNode = parent;
    }

    return val;
  }
}

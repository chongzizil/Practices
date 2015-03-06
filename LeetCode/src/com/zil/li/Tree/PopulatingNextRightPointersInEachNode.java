package com.zil.li.Tree;

import com.zil.li.datastructure.TreeLinkNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by youlongli on 2/10/15.
 *
 * https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * Idea: BFS.
 */
public class PopulatingNextRightPointersInEachNode {
  /**
   * Use two pointers.
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public void solutionA(TreeLinkNode root) {
    TreeLinkNode start = root; // Always point to the start of a level

    while (start != null && start.left != null) {
      TreeLinkNode curr = start;
      // Start from the left to the right. Construct the below level links.
      while (curr != null) {
        curr.left.next = curr.right;
        curr.right.next = curr.next == null ? null : curr.next.left; // Note: check
        curr = curr.next;
      }

      start = start.left;
    }
  }

  /**
   * Recursive
   * Time complexity: O(n)
   * Space complexity: O(h) (stack)
   */
  public void solutionB(TreeLinkNode root) {
    helper(root);
  }

  private void helper(TreeLinkNode node) {
    if (node == null) {
      return;
    }

    if (node.left != null) {
      node.left.next = node.right;
    }

    if (node.right != null) {
      node.right.next = node.next == null ? null : node.next.left;
    }

    helper(node.left);
    helper(node.right);
  }

  /**
   * Time complexity: O(n)
   * Space complexity: O(n)
   */
  public void solutionC(TreeLinkNode root) {
    Deque<TreeLinkNode> queue = new ArrayDeque<TreeLinkNode>();

    if (root == null) {
      return;
    }

    queue.addLast(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeLinkNode curr = queue.pollFirst();
        if (i == size - 1) {
          curr.next = null;
        } else {
          curr.next = queue.peekFirst();
        }
        if (curr.left != null) {
          queue.addLast(curr.left);
        }
        if (curr.right != null) {
          queue.addLast(curr.right);
        }
      }
    }
  }
}

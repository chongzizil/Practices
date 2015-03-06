package com.zil.li.Tree;

import com.zil.li.datastructure.TreeLinkNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by youlongli on 2/11/15.
 *
 * https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class PopulatingNextRightPointersInEachNodeII {
  /**
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public void solutionA(TreeLinkNode root) {
    TreeLinkNode start = root;

    while (start != null) {
      // Use a dummy node
      TreeLinkNode dummy = new TreeLinkNode(0);
      // The previous node in the same level
      TreeLinkNode prev = dummy;
      TreeLinkNode curr = start;

      while(curr != null) { // No need to check left child since it might be null
        if (curr.left != null) {
          prev.next = curr.left;
          prev = curr.left;
        }

        if (curr.right != null) {
          prev.next = curr.right;
          prev = curr.right;
        }
        curr = curr.next;
      }

      // Get the leftmost child node in the next level
      start = dummy.next;
    }
  }

  /**
   * Time complexity: O(n)
   * Space complexity: O(n)
   */
  public void solutionB(TreeLinkNode root) {
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

  public void solutionC(TreeLinkNode root) {
    if (root == null) {
      return;
    }

    List<List<TreeLinkNode>> levels = getLevels(root);

    for (int i = 0; i < levels.size(); i++) {
      List<TreeLinkNode> level = levels.get(i);
      for (int j = 0; j < level.size(); j++) {
        TreeLinkNode curr = level.get(j);
        TreeLinkNode next = j == level.size() - 1 ? null : level.get(j + 1);
        curr.next = next;
      }
    }
  }

  private List<List<TreeLinkNode>> getLevels(TreeLinkNode root) {
    List<List<TreeLinkNode>> levels = new ArrayList<List<TreeLinkNode>>();
    Deque<TreeLinkNode> queue = new ArrayDeque<TreeLinkNode>();

    queue.addLast(root);

    while (!queue.isEmpty()) {
      List<TreeLinkNode> level = new ArrayList<TreeLinkNode>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeLinkNode node = queue.pollFirst();
        level.add(node);
        if (node.left != null) {
          queue.addLast(node.left);
        }
        if (node.right != null) {
          queue.addLast(node.right);
        }
      }
      levels.add(level);
    }

    return levels;
  }
}

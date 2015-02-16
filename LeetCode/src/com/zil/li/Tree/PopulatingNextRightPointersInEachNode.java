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
  public void solutionA(TreeLinkNode root) {
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

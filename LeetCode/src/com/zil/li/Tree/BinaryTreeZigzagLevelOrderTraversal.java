package com.zil.li.Tree;

import com.zil.li.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by youlongli on 2/11/15.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
    boolean isEven = false;

    if (root == null) {
      return res;
    }

    queue.addLast(root);

    while(!queue.isEmpty()) {
      List<Integer> list = new ArrayList<Integer>();
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        TreeNode node = queue.pollFirst();
        list.add(node.val);
        if (node.left != null) {
          queue.addLast(node.left);
        }
        if (node.right != null) {
          queue.addLast(node.right);
        }
      }
      if (isEven) {
        reverse(list);
      }
      isEven = !isEven;
      res.add(list);
    }

    return res;
  }

  private void reverse(List<Integer> level) {
    for (int i = 0, j = level.size() - 1; i < j; i++, j--) {
      int tmp = level.get(i);
      level.set(i, level.get(j));
      level.set(j, tmp);
    }
  }
}

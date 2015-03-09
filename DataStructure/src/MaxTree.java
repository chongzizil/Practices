
import datastructure.TreeNode;

import java.util.Stack;

/**
 * Created by youlongli on 3/8/15.
 */
public class MaxTree {
  public static TreeNode maxTree(int[] A) {
    Stack<TreeNode> stack = new Stack<TreeNode>();

    TreeNode root = null;
    for (int i = 0; i <= A.length; i++) {
      TreeNode right = i == A.length ? new TreeNode(Integer.MAX_VALUE)
          : new TreeNode(A[i]);

      while (!stack.isEmpty()) {
        if (right.val > stack.peek().val) {
          TreeNode nodeNow = stack.pop();

          if (stack.isEmpty()) {
            right.left = nodeNow;

          } else {
            TreeNode left = stack.peek();
            if (left.val > right.val) {
              right.left = nodeNow;
            } else {
              left.right = nodeNow;
            }
          }
        } else {
          break;
        }
      }
      stack.push(right);
    }
    return stack.peek().left;
  }
}

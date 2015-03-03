import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 3/3/15.
 *
 * Get a ordered list of Integers from BST between input "MIN" to "MAX"
 */
public class BSTMinToMax {
  public List<Integer> solution(TreeNode root, int min, int max) {
    List<Integer> res = new ArrayList<>();

    helper(res, root, min, max);

    return res;
  }

  private void helper(List<Integer> res, TreeNode node, int min, int max) {
    if (node == null || node.val < min || node.val > max) {
      return;
    }

    helper(res, node.left, min, max);
    res.add(node.val);
    helper(res, node.right, min, max);
  }
}

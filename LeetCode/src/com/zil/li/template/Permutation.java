package com.zil.li.template;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 2/1/15.
 * This templates can be modified to solve subsets, subsetsII, permutations and permutationsII.
 */
public class Permutation {
  /**
   * This method use backtracking to returns all non-duplicate subsets of an array of all unique integers. Using a tree like graph will be much easy
   * to comprehend and explain...
   **/
  public void subsetsHelper(List<List<Integer>> res, List<Integer> list, int[] num, int pos) {
    res.add(new ArrayList<Integer>(list));
    for (int i = pos; i < num.length; i++) {
      /**
       * If duplicates exist in the array, the codes commented are used.
       * e.g [1, 2, 2] will produce [1, 2] and [1, 2] which are exactly same...
       */
//      if (i != pos && num[i] == num[i - 1]) {
//        continue;
//      }
      list.add(num[i]);
      subsetsHelper(res, list, num, pos + 1);
      list.remove(list.size() - 1);
    }
  }
}

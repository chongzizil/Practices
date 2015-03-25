package com.zil.li.bit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 3/14/15.
 *
 * http://lintcode.com/en/problem/single-number-iii/
 *
 * Idea: Use XOR to all elements and get the result which must be larger than 0, because for two single number
 * a and b, we have a ^ b = z != 0, and for position where the bit == 1, it means where a and b is different. (1 ^ 0 = 1)
 * Hence we can divide the array elements in two parts where for the position is 1 or 0, and get Single Number I problem to solve.
 */
public class SingleNumberIII {
  public List<Integer> solutionA(int[] A) {
    int x = 0;
    for (int i = 0; i < A.length; i++) {
      x ^= A[i];
    }

    int pos = 0;
    for (int i = 0; i < 32; i++) {
      if (((x >> i) & 1) == 1) {
        pos = i;
        break;
      }
    }

    int one = 0;
    int two = 0;
    for (int i = 0; i < A.length; i++) {
      if (((A[i] >> pos) & 1) == 0) {
        one ^= A[i];
      } else {
        two ^= A[i];
      }
    }

    List<Integer> res = new ArrayList<Integer>();
    res.add(one);
    res.add(two);
    return res;
  }

  public List<Integer> solutionB(int[] A) {
    // write your code here
    int x = 0;
    for (int i = 0; i < A.length; i++) {
      x ^= A[i];
    }
    int y = x & (-x); // 取反加1, (-x) = ~x + 1, will get a number with only 1 bit == 1.

    int one = 0;
    int two = 0;
    for (int i = 0; i < A.length; i++) {
      if ((y & A[i]) == 0) {
        one ^= A[i];
      } else {
        two ^= A[i];
      }
    }

    List<Integer> res = new ArrayList<Integer>();
    res.add(one);
    res.add(two);
    return res;
  }
}

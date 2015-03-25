package com.zil.li.array;

import java.util.ArrayList;

/**
 * Created by youlongli on 3/14/15.
 *
 * http://lintcode.com/en/problem/majority-number-ii/
 */
public class MajorityElementII {
  public int majorityNumber(int[] nums) {
    int candidateOne = Integer.MIN_VALUE;
    int countOne = 0;
    int candidateTwo = Integer.MIN_VALUE;
    int countTwo = 0;

    // Note: Check the candidate first, then the count, otherwise two candidate might be the same one...
    for (int num : nums) {
      if (candidateOne == num) {
        countOne++;
      } else if (candidateTwo == num) {
        countTwo++;
      } else if (countOne == 0) {
        candidateOne = num;
        countOne++;
      } else if (countTwo == 0) {
        candidateTwo = num;
        countTwo++;
      } else {
        countOne--;
        countTwo--;
      }
    }

    countOne = 0;
    countTwo = 0;
    for (int num : nums) {
      if (candidateOne == num) {
        countOne++;
      } else if (candidateTwo == num) {
        countTwo++;
      }
    }

    return countOne > countTwo ? candidateOne : candidateTwo;
  }
}

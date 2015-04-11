package com.zil.li.bit;

/**
 * Created by youlongli on 3/1/15.
 * <p>
 * https://oj.leetcode.com/problems/single-number-ii/
 */
public class SingleNumberII {
  /**
   * Most simple solution. Use an array to count each digit.
   */
  public int singleNumber(int[] A) {
    int res = 0;
    int[] bits = new int[32];
    for (int i = 0; i < 32; i++) {
      for (int j = 0; j < A.length; j++) {
        if (((A[j] >> i) & 1) == 1) {
          bits[i]++;
        }
      }
      res |= (bits[i] % 3) << i;
    }

    return res;
  }

  /**
   * Get rid of the array.
   */
  public int singleNumberA(int[] A) {
    int res = 0;
    for (int i = 0; i < 32; i++) {
      int sum = 0;
      for (int j = 0; j < A.length; j++) {
        if (((A[j] >> i) & 1) == 1) {
          sum++;
        }
      }
      res |= (sum % 3) << i;
    }

    return res;
  }

  // Another neat solution, and much more easy to understand...
  // It use two bit to store the number of times of 1 appears in
  // the array. (ones, twos: 00 -> 10 -> 01 -> 00)

  /**
   * Another neat solution, and much more easy to understand...
   * It use two bit to store the number of times of 1 appears in
   * the array. (ones, twos: 00 -> 10 -> 01 -> 00)
   *
   * https://oj.leetcode.com/discuss/6632/challenge-me-thx
   * For 'ones', we can get 'ones = ones ^ A[i]; if (twos == 1) then ones = 0', that can be tansformed to 'ones = (ones ^ A[i]) & ~twos'.
   * Similarly, for 'twos', we can get 'twos = twos ^ A[i]; if (ones* == 1) then twos = 0' and 'twos = (twos ^ A[i]) & ~ones'. Notice that 'ones*' is the value of 'ones' after calculation, that is why twos is calculated later.
   */
  public int solutionB(int[] A) {
    int ones = 0, twos = 0;
    for (int i = 0; i < A.length; i++) {
      ones = (ones ^ A[i]) & ~twos;
      twos = (twos ^ A[i]) & ~ones;
    }
    return ones;
  }

  // One very neat solution
  public int solutionC(int[] A) {
    int ones = 0, twos = 0, threes = 0;
    for (int i = 0; i < A.length; i++) {
      twos |= A[i] & ones;
      ones ^= A[i];
      threes = ones & twos;
      ones &= ~threes;
      twos &= ~threes;
    }
    return ones;
  }
}

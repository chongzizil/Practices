package com.zil.li.array;

/**
 * Created by youlongli on 2/1/15.
 * Ideas: https://oj.leetcode.com/discuss/8472/share-my-o-n-time-solution
 */
public class NextPermutation {
  /**
   * The idea (Arrangement exists):
   * 1. First search from right, find the first number i which is small than the next on the right.
   * 2. Than search again from right to that number i, find the first number j which is larger than i. (Numbers from i to the rightmost is sorted/descending, so in another word, is to find the smallest number j which is larger than i)
   * 3. Swap i and j, then reverse numbers from the i + 1 to the rightmost one.
   * Runtime: 224 ms
   */
  public void solution(int[] num) {
    if (num == null) {
      return;
    }

    for (int i = num.length - 2; i >= 0; i--) {
      if (num[i] < num[i + 1]) {
        int j;
        for (j = num.length - 1; j > i; j--) {
          if (num[j] > num[i]) {
            break;
          }
        }

        swap(num, i, j);
        reverse(num, i + 1, num.length - 1);
        return;
      }
    }

    reverse(num, 0, num.length - 1);
  }

  public void swap(int[] num, int i, int j) {
    int tmp = num[i];
    num[i] = num[j];
    num[j] = tmp;
  }

  public void reverse(int[] num, int beg, int end) {
    for (int i = beg, j = end; i < j; i++, j--) {
      swap(num, i, j);
    }
  }
}

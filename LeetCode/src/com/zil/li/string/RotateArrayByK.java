package com.zil.li.string;

/**
 * Created by youlongli on 1/5/15.
 */
public class RotateArrayByK {
  public enum DIRECTION {
    LEFT,
    RIGHT
  }

  private int[] array;
  private int k;

  public void solutionA(int[] array, int k, DIRECTION direction) {
    this.array = array;
    this.k = k;

    if (array.length == 0 || k == array.length) {
      return;
    }

    k = k % array.length;
    int gcd = getGCD(array.length, k);

    switch (direction) {
      case LEFT:
        rotateLeft(gcd);
        break;
      case RIGHT:
        rotateRight(gcd);
        break;
      default: throw new IllegalArgumentException("Wrong direction...");
    }
  }

  private int getGCD(int a, int b) {
    return b == 0 ? a : getGCD(b, a % b);
  }

  private void rotateRight(int gcd) {
    for (int i = 0; i < gcd; i++) {
      int prev = i;
      int prevTmp = array[prev];
      int nextTmp = array[prev];
      while (true) {
        int next = (prev + k) % array.length;
        if (next == i) {
          array[next] = prevTmp;
          break;
        } else {
          nextTmp = array[next];
          array[next] = prevTmp;
          prev = next;
          prevTmp = nextTmp;
        }
      }
    }
  }

  private void rotateLeft(int gcd) {
    for (int i = 0; i < gcd; i++) {
      int prev = i;
      int tmp = array[prev];
      while (true) {
        int next = (prev + k) % array.length;
        if (next == i) {
          array[prev] = tmp;
          break;
        } else {
          array[prev] = array[next];
          prev = next;
        }
      }
    }
  }
}

package Chpater3;

/**
 * Created by youlongli on 3/22/15.
 */
public class One {
  static int stackSize = 10;
  static int[] buffer = new int [stackSize * 3];
  static int[] stackPointer = new int[]{-1, -1, -1};

  static void push(int stackNum, int value) {
    if (stackPointer[stackNum] + 1 >= stackSize) {
      return; // Should throw a exception and handle it well
    }
    stackPointer[stackNum]++;
    buffer[topOfStack(stackNum)] = value;
  }

  static int pop(int stackNum) throws Exception {
    if (isEmpty(stackNum)) {
      throw new NullPointerException();
    }
    int res = buffer[topOfStack(stackNum)];
    buffer[topOfStack(stackNum)] = 0;
    stackPointer[stackNum]--;
    return res;
  }

  static int peek(int stackNum) throws Exception  {
    if (isEmpty(stackNum)) {
      throw new NullPointerException();
    }
    return buffer[topOfStack(stackNum)];
  }

  static boolean isEmpty(int stackNum) {
    return stackPointer[stackNum] == -1;
  }

  static int topOfStack(int stackNum) {
    return stackNum * stackSize + stackPointer[stackNum];
  }
}

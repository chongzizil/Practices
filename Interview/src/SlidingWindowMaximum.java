import java.util.*;

/**
 * Created by youlongli on 4/3/15.
 *
 * http://articles.leetcode.com/2011/01/sliding-window-maximum.html
 */
public class SlidingWindowMaximum {
  /**
   * Brutal force.
   * Time complexity: O(nw) - For each window, do a linear search inorder to find the largest element...
   */
  public List<Integer> solutionA(int[] A, int w) {
    List<Integer> res = new ArrayList<>();

    for (int i = 0; i < A.length - w + 1; i++) {
      int max = Integer.MIN_VALUE;
      for (int j = 0; j < w; j++) {
        max = Math.max(max, A[i + j]);
      }
      res.add(max);
    }

    return res;
  }
  /**
   * Idea: use priority queue.
   * Time complexity: O(nlogn) - Normally it need n times push/offer operation which takes O(nlogw). Poll and peek take
   * only constant time. The problem is if the array is sorted, then the queue will continue to grow because the while
   * loop will never run. Hence the run time O(nlogn).
   */
  private class Pair {
    int elem;
    int index;
    public Pair(int elem, int index) {
      this.elem = elem;
      this.index = index;
    }
  }

  public List<Integer> solutionB(int[] A, int w) {
    List<Integer> res = new ArrayList<>();
    // Using priority queue, with initial size w and comparator since we need to extract the max element
    PriorityQueue<Pair> queue = new PriorityQueue<>(w, new Comparator<Pair>() {
      @Override
      public int compare(Pair o1, Pair o2) {
        return o2.elem -o1.elem;
      }
    });

    // Add all elements of the first window.
    for (int i = 0; i < w; i++) {
      queue.offer(new Pair(A[i], i));
    }

    for (int i = w; i < A.length; i++) {
      // First get the max element and its index, add it to the result list.
      Pair maxPair = queue.peek();
      res.add(maxPair.elem);

      // Remove any potential max element which is outside the current window [i - w, i - 1]
      while (maxPair.index <= i - w) {
        queue.poll();
        maxPair = queue.peek();
      }

      queue.offer(new Pair(A[i], i));
    }

    // Max element of the last window
    res.add(queue.poll().elem);
    return res;
  }

  /**
   * Idea: use double ended queue.
   * Time complexity: O(n) - Use a double ended queue and keep the max element in the head. All operations for it
   * runs in constant time. Hence the O(n) run time.
   * The brilliant and useful idea is to minimize the size of the queue, instead of keeping w elements inside,
   * we always try to throw the useless and invalid elements.
   * i.g. [5, 3, 1, 10, 7], ... For such a window, there's no point to store 5, 3 and 1 since they are going to be
   * throw out the window before 10 and will have 0 chance to be the max element. To summarize, any element small than
   * the current new element, can be threw away :)
   */
  public List<Integer> solutionC(int[] A, int w) {
    List<Integer> res = new ArrayList<>();
    // A double ended queue which stores the index of elements. The max element index is always in the head.
    Deque<Integer> queue = new ArrayDeque<>();

    // Add all elements of the first window.
    for (int i = 0; i < w; i++) {
      // Clean the queue
      while (!queue.isEmpty() && A[i] >= A[queue.peekLast()]) {
        queue.pollLast();
      }
      queue.addLast(i);
    }

    for (int i = w; i < A.length; i++) {
      res.add(A[queue.peekFirst()]);
      // Clean the queue
      while (!queue.isEmpty() && A[i] >= A[queue.peekLast()]) {
        queue.pollLast();
      }
      // Remove elements outside of the window [i - w, i - 1] since the current one will be one step right.
      while (!queue.isEmpty() && queue.peekFirst() <= i - w) {
        queue.pollFirst();
      }
      queue.add(i);
    }

    res.add(A[queue.peekFirst()]);
    return res;
  }
}

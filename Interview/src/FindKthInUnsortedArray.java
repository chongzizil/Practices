import java.util.*;

/**
 * Created by youlongli on 4/11/15.
 *
 * Find the kth largest element int a unsorted array.
 *
 * Assume no duplicates.
 */
public class FindKthInUnsortedArray {
  /**
   * Use quick select (quick sort).
   * Time: O(n) (?)
   * Space: O(n) (Can be improved)
   */
  public int solutionA(int[] num, int k) {
    return quickSelect(num, 0, num.length - 1, k);
  }

  private int quickSelect(int[] num, int l, int r, int k) {
    int leftEnd = partition(num, l, r);
    int leftNum = leftEnd - l + 1;

    if (k < leftNum) {
      return quickSelect(num, l, leftEnd, k);
    } else if (k > leftNum) {
      return quickSelect(num, leftEnd + 1, r, k - leftNum);
    } else {
      return num[leftEnd];
    }
  }

  // Return the end of the left part.
  private int partition(int[] num, int l, int r) {
    Random rd = new Random();
    int pivot = rd.nextInt(r - l + 1) + l;

    while (true) {
      while (l < r && num[l] < num[pivot]) l++;
      while (l < r && num[r] > num[pivot]) r--;
      if (l > r) break;
      swap(num, l, r);
      l++; r--;
    }

    return l - 1;
  }

  private void swap(int[] num, int i, int j) {
    int tmp = num[i];
    num[i] = num[j];
    num[j] = tmp;
  }

  /**
   * Use priority queue.
   * Time: nlogk
   * Space: logk
   */
  public int solutionB(int[] num, int k) {
    // Note: Priority queue will increment the capacity, this code is buggy!!!
    // Add a self implement heap will do the job :)
    PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
      }
    });
    for (int i : num) {
      pq.offer(i);
    }

    return pq.poll();
  }
}

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
  public int solutionA(List<Integer> num, int k) {
    return quickSelect(num, k);
  }

  private int quickSelect(List<Integer> num, int k) {
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
    Random rd = new Random();
    int pivot = rd.nextInt(1) * num.size();

    for (int i = 0; i < num.size(); i++) {
      if (num.get(i) < num.get(pivot)) {
        left.add(num.get(i));
      } else if (num.get(i) > num.get(pivot)) {
        right.add(num.get(i));
      }
    }

    if (k <= left.size()) {
      return quickSelect(left, k);
    } else if (k > num.size() - right.size()) {
      return quickSelect(right, k - (num.size() - right.size()));
    } else {
      return num.get(pivot);
    }
  }

  /**
   * Use priority queue.
   * Time: nlogk
   * Space: logk
   */
  public int solutionB(List<Integer> num, int k) {
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

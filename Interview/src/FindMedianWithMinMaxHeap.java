import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by youlongli on 2/26/15.
 */
public class FindMedianWithMinMaxHeap {
  private static Queue<Integer> maxHeap, minHeap;

  public FindMedianWithMinMaxHeap() {
    maxHeap = new PriorityQueue<Integer>(20, new Comparator<Integer>() {
      @Override
      public int compare(Integer i1, Integer i2) {
        return i2 - i1;
      }
    });
    minHeap = new PriorityQueue<Integer>(20);
  }

  public void addNumberA(int i) {
    maxHeap.offer(i);

    if (maxHeap.size() - minHeap.size() == 2) {
      minHeap.offer(maxHeap.poll());
    } else {
      if (minHeap.size() == 0) {
        return;
      } else if (maxHeap.peek() > minHeap.peek()) {
        minHeap.offer(maxHeap.poll());
        maxHeap.offer(minHeap.poll());
      }
    }
  }

  public double getMedian() {
    if (maxHeap.isEmpty()) {
      return -1;
    }

    if (maxHeap.size() == minHeap.size()) {
      return (double)(maxHeap.peek() + minHeap.peek()) / 2.0;
    } else {
      return maxHeap.peek();
    }
  }
}

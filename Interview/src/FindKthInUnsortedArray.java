import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by youlongli on 4/11/15.
 *
 * Find the kth largest element int a unsorted array.
 *
 * Assume no duplicates.
 */
public class FindKthInUnsortedArray {
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
}

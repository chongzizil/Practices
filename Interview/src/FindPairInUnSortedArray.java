import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 3/9/15.
 *
 * Given an unsorted array, find all pairs which the first element is larger than the second one
 * and the first element's index is before the second element's index.
 *
 * Idea: use merge sort.
 */
public class FindPairInUnSortedArray {
  public List<int[]> solution (int[] num) {
    List<int[]> res = new ArrayList<>();

    sort(res, num, 0, num.length);

    return res;
  }

  private void sort(List<int[]> res, int[] num, int l, int r) {
    if (l + 1 < r) {
      int mid = l + (r - l) / 2;
      sort(res, num, l, mid);
      sort(res, num, mid, r);
      merge(res, num, l, mid, r);
    }
  }

  private void merge(List<int[]> res, int[] num, int l, int mid, int r) {
    int[] tmp = new int[num.length];
    for (int i = l; i < r; i++) {
      tmp[i] = num[i];
    }

    int i = l;
    int j = mid;
    int k = l;

    while (i < mid && j < r) {
      if (tmp[i] <= tmp[j]) {
        num[k] = tmp[i];
        i++;
      } else {
        res.add(new int[]{tmp[i], tmp[j]});
        num[k] = tmp[j];
        j++;
      }
      k++;
    }

    if (i < mid) {
      num[k] = tmp[i];
      i++;
      k++;
    }
  }
}

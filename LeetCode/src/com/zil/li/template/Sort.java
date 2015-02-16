package com.zil.li.template;

/**
 * Created by youlongli on 2/7/15.
 */
public class Sort {
  public void QuickSort(int[] num) {
    quickSortHelper(num, 0, num.length - 1);
  }

  private void quickSortHelper(int[] num, int i, int j) {
    int mid = i + (j - i) / 2;
    int low = i;
    int high = j;

    while (i <= j) {
      while (num[i] < num[mid]) {
        i++;
      }

      while (num[j] > num[mid]) {
        j--;
      }

      if (i <= j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
        i++;
        j--;
      }
    }

    if (low < j) {
      quickSortHelper(num, low, j);
    }
    if (high > i) {
      quickSortHelper(num, i, high);
    }
  }

  public void MergeSort(int[] num) {
    MergeSortHelper(num, 0, num.length - 1);
  }

  private void MergeSortHelper(int[] num, int l, int r) {
    if (l < r) {
      int mid = l + (r - l) / 2;
      MergeSortHelper(num, l, mid);
      MergeSortHelper(num, mid + 1, r);
      merge(num, l, mid, r);
    }
  }

  private void merge(int[] num, int l, int mid, int r) {
    int[] tmp = new int[num.length];
    for (int i = l; i <= r; i++) {
      tmp[i] = num[i];
    }

    int i = l;
    int j = mid + 1;
    int k = l;

    while (i <= mid && j <= r) {
      if (tmp[i] < tmp[j]) {
        num[k] = tmp[i];
        i++;
      } else {
        num[k] = tmp[j];
        j++;
      }
      k++;
    }

    while (i <= mid) {
      num[k] = tmp[i];
      i++;
      k++;
    }
  }
}

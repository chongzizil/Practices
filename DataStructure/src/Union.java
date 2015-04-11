import java.util.Arrays;

/**
 * Created by youlongli on 4/9/15.
 */
public class Union {
  int[] array;
  int[] arraySize;

  public Union(int size) {
    array = new int[size];
    arraySize = new int[size];
    for (int i = 0; i < size; i++) {
      array[i] = i;
      arraySize[i] = 1;
    }
  }

  public void union(int p, int q) {
    int i = findRoot(p);
    int j = findRoot(q);
    if (i == j) return;
    if (arraySize[i] < arraySize[j]) {
      array[i] = j;
      arraySize[j] += arraySize[i];
    } else {
      array[j] = i;
      arraySize[i] += arraySize[j];
    }
  }

  public boolean isConnected(int p, int q) {
    int i = findRoot(p);
    int j = findRoot(q);
    return i == j;
  }

  private int findRoot(int i) {
    while (array[i] != i) {
      i = array[i];
    }
    return i;
  }
}

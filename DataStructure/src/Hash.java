/**
 * Created by youlongli on 3/15/15.
 */
public class Hash {
  private int tableSize;

  public Hash(int tableSize) {
    this.tableSize = tableSize;
  }

  public int hash(String key) {
    int sum = 0;
    for (int i = 0; i < key.length(); i++) {
      sum = sum * 33 + (int)(key.charAt(i));
      sum %= tableSize;
    }
    return sum;
  }
}

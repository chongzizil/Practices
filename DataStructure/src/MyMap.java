/**
 * Created by youlongli on 4/8/15.
 */
public class MyMap<K, V> {
  private class Entry<K, V> {
    K key;
    V value;
    Entry<K, V> next;

    public Entry(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  private Entry<K, V>[] table;
  private int size;
  private double loadFactor;

  public MyMap() {
    table = new Entry[4];
    size = 0;
    loadFactor = 0.75;
  }

  public boolean put(K key, V value) {
    if (key == null) {
      return false;
    }

    if ((double)size / (double)table.length > loadFactor) {
      resize();
    }

    int index = hash(key) % table.length;
    put(table, index, key, value);
    size++;
    return true;
  }

  private void put(Entry<K, V>[] currTable, int index, K key, V value) {
    for (Entry<K, V> entry = currTable[index]; entry != null; entry = entry.next) {
      if (entry.key.equals(key)) {
        entry.value = value;
        return;
      }
    }
    Entry<K, V> newEntry = new Entry<>(key, value);
    newEntry.next = currTable[index];
    currTable[index] = newEntry;
  }

  public V get(K key) {
    int index = hash(key) % table.length;
    for (Entry<K, V> entry = table[index]; entry != null; entry = entry.next) {
      if (entry.key.equals(key)) {
        return entry.value;
      }
    }
    return null;
  }

  public boolean containsKey(K key) {
    int index = hash(key) % table.length;
    for (Entry<K, V> entry = table[index]; entry != null; entry = entry.next) {
      if (entry.key.equals(key)) {
        return true;
      }
    }
    return false;
  }

  public void resize() {
    size = 0;
    Entry<K, V>[] newTable = new Entry[table.length * 2];
    for (Entry<K, V> entry : table) {
      for (; entry != null; entry = entry.next) {
        int index = hash(entry.key) % newTable.length;
        put(newTable, index, entry.key, entry.value);
        size++;
      }
    }
    table = newTable;
  }

  public int size() {
    return size;
  }

  public int hash(K key) {
    return key.hashCode() & 0x7fffffff;
  }
}

package Chapter1;

/**
 * Created by youlongli on 3/19/15.
 */
public class One {
  // Assume ASCII
  public static boolean isUniqueCharsA(String s) {
    if (s.length() > 128) {
      return false;
    }

    boolean[] chars = new boolean[128];
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (chars[c]) {
        return false;
      }
      chars[c] = true;
    }
    return true;
  }

  // Assume 'a' - 'z'
  public static boolean isUniqueCharsB(String s) {
    if (s.length() > 26) {
      return false;
    }

    int bit = 0;
    for (int i = 0; i < s.length(); i++) {
      int val = s.charAt(i) - 'a';
      if ((bit & (1 << val)) > 0) {
        return false; // Found duplicate
      }
      bit = bit | 1 << val;
    }
    return true;
  }

  public static void main(String[] args) {
    String[] words = {"abcde", "hello", "apple", "kite", "padle"};
    for (String word : words) {
      System.out.println(word + ": " + isUniqueCharsA(word) + " " + isUniqueCharsB(word));
    }
  }
}

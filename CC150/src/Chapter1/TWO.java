package Chapter1;

/**
 * Created by youlongli on 3/22/15.
 */
public class Two {
  public static void reverseStr(char[] s) {
    for (int i = 0, j = s.length - 1; i < j; i++, j--) {
      char tmp = s[i];
      s[i] = s[j];
      s[j] = tmp;
    }
  }

  public static void main(String[] args) {
    String[] words = {"abcde", "hello", "apple", "kite", "padle"};
    for (String word : words) {
      char[] chars = word.toCharArray();
      reverseStr(chars);
      System.out.println(word + ": " + String.valueOf(chars));
    }
  }
}

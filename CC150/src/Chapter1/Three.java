package Chapter1;

import java.util.Arrays;

/**
 * Created by youlongli on 3/22/15.
 */
public class Three {
  // Time: O(nlogn)
  public static String sortStr(String s) {
    char[] charS = s.toCharArray();
    Arrays.sort(charS);
    return new String(charS);
  }

  public static boolean anagramA(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    return sortStr(s).equals(sortStr(t));
  }

  // Assume ASCII
  public static boolean anagramB(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] letters = new int[128];
    int uniqueChars = 0;
    int completeChars = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (letters[c] == 0) {
        uniqueChars++;
      }
      letters[c]++;
    }
    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      if (letters[c] == 0) {
        return false;
      }
      letters[c]--;
      if (letters[c] == 0) {
        completeChars++;
      }
    }

    return true; // Since both string has the same length, if the for loop ends, then they must be anagram... Otherwise some letter[x] will be less then 0.
//    return completeChars == uniqueChars;
  }

  public static void main(String[] args) {
    String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
    for (String[] pair : pairs) {
      String word1 = pair[0];
      String word2 = pair[1];
      System.out.println(word1 + ", " + word2 + ": ");
      System.out.println(anagramA(word1, word2));
      System.out.println(anagramB(word1, word2));
    }
  }
}

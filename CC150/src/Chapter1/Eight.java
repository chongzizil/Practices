package Chapter1;

/**
 * Created by youlongli on 3/22/15.
 */
public class Eight {
  public static boolean isSubstring(String haystack, String needle) {
    for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
      int j = 0;
      for (; j < needle.length(); j++) {
        if (haystack.charAt(i + j) != needle.charAt(j)) {
          break;
        }
      }
      if (j == needle.length()) {
        return true;
      }
    }
    return false;
  }

  public static boolean isRotation(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    return isSubstring(s + s, t);
//    return (s + s).indexOf(t) >= 0;
  }

  public static void main(String[] args) {
    String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
    for (String[] pair : pairs) {
      String word1 = pair[0];
      String word2 = pair[1];
      boolean is_rotation = isRotation(word1, word2);
      System.out.println(word1 + ", " + word2 + ": " + is_rotation);
    }
  }
}

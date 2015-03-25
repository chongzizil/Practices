import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by youlongli on 3/13/15.
 *
 * Given a string, check if we can generate palindrome out of its characters.
 * Follow up: Return all possible palindromes. (Backtracking, permutation)
 */
public class PalindromePermutation {
  private Map<Character, Integer> getCount(String s) {
    Map<Character, Integer> count = new HashMap<Character, Integer>();
    for (char c : s.toCharArray()) {
      if (count.containsKey(c)) {
        count.put(c, count.get(c) + 1);
      } else {
        count.put(c, 1);
      }
    }
    return count;
  }

  public boolean canBePalindrome(String s) {
    Map<Character, Integer> count = getCount(s);

    int oddCount = 0;
    for (char key : count.keySet()) {
      if (count.get(key) % 2 != 0) {
        oddCount++;
      }
    }

    return oddCount < 2;
  }

  public List<String> getPalindromePermutation(String s) {
    List<String> res = new ArrayList<String>();
    if (canBePalindrome(s)) {
      List<Character> half = new ArrayList<Character>();
      Map<Character, Integer> count = getCount(s);
      StringBuilder sb = new StringBuilder();
      char oddChar = ' ';

      for (char key : count.keySet()) {
        if (count.get(key) % 2 == 0) {
          for (int i = 0; i < count.get(key) / 2; i++) {
            half.add(key);
          }
        } else {
          oddChar = key;
        }
      }

      boolean[] visit = new boolean[half.size()];
      helper(res, half, sb, visit);

      for (int i = 0; i < res.size(); i++) {
        String palindrome = oddChar == ' ' ? res.get(i) + reverse(res.get(i))
            : res.get(i) + oddChar + reverse(res.get(i));
        res.set(i, palindrome);
      }
    }

    return res;
  }

  private void helper(List<String> res, List<Character> chars, StringBuilder sb, boolean[] visit) {
    if (sb.length() == chars.size()) {
      res.add(sb.toString());
    }

    for (int i = 0; i < chars.size(); i++) {
      if (visit[i] || i != 0 && chars.get(i) == chars.get(i - 1) && !visit[i - 1]) {
        continue;
      }
      sb.append(chars.get(i));
      visit[i] = true;
      helper(res, chars, sb, visit);
      visit[i] = false;
      sb.setLength(sb.length() - 1);
    }
  }

  private String reverse(String s) {
    char[] chars = s.toCharArray();
    for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
      char tmp = chars[i];
      chars[i] = chars[j];
      chars[j] = tmp;
    }
    return new String(chars);
  }
}

package com.zil.li.DP;

/**
 * Created by youlongli on 2/26/15.
 */
public class RegularExpressionMatching {
  public boolean isMatch(String s, String p) {
    if (s == null || p == null) {
      return false;
    }

    // mem_ij indicate whether s.substring(i) and p.substring(j) will match.
    int[][] mem = new int[s.length() + 1][p.length() + 1];

    // Init. -1: no mem, 0: not match, 1: match
    for (int i = 0; i <= s.length(); i++) {
      for (int j = 0; j <= p.length(); j++) {
        mem[i][j] = -1;
      }
    }

    return helper(s, 0, p, 0, mem);
  }

  private boolean helper(String s, int indexS, String p, int indexP, int[][] mem) {
    int lenS = s.length();
    int lenP = p.length();

    // Have mem
    if (mem[indexS][indexP] != -1) {
      return mem[indexS][indexP] == 1;
    }

    // If pattern is done, str should also
    if (indexP >= lenP) {
      mem[indexS][indexP] = indexS >= lenS ? 1 : 0;
      return mem[indexS][indexP] == 1;
    }

    if (indexP != lenP - 1 && p.charAt(indexP + 1) == '*') {
      // Next is *
      if (helper(s, indexS, p, indexP + 2, mem)) {
        // Skip
        mem[indexS][indexP] = 1;
        return true;
      }

      for (int i = indexS; i < lenS; i++) {
        // Note: Use i, not indexS!
        if (!isSame(s.charAt(i), p.charAt(indexP))) {
          mem[indexS][indexP] = 0;
          return false;
        }

        if (helper(s, i + 1, p, indexP + 2, mem)) {
          mem[indexS][indexP] = 1;
          return true;
        }
      }

      mem[indexS][indexP] = 0;
      return false;
    } else {
      // No *, just check if match, remember to check indexS first
      if (indexS >= s.length()) {
        mem[indexS][indexP] = 0;
        return false;
      }

      if (!isSame(s.charAt(indexS), p.charAt(indexP))) {
        mem[indexS][indexP] = 0;
        return false;
      }

      mem[indexS][indexP] = helper(s, indexS + 1, p, indexP + 1, mem) ? 1 : 0;

      return mem[indexS][indexP] == 1;
    }
  }

  private boolean isSame(char s, char p) {
    return p == '.' || s == p;
  }
}

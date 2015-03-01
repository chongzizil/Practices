package com.zil.li.hashmap;

import java.util.*;

/**
 * Created by youlongli on 2/28/15.
 */
public class RepeatedDNASequences {
  public List<String> findRepeatedDnaSequences(String s) {
    Set<Integer> found = new HashSet<>();
    Set<Integer> added = new HashSet<>();
    List<String> res = new ArrayList<>();
    char[] map = new char[26];
    map['A' - 'A'] = 0;
    map['C' - 'A'] = 1;
    map['G' - 'A'] = 2;
    map['T' - 'A'] = 3;

    for(int i = 0; i < s.length() - 9; i++) {
      int bit = 0;
      for(int j = i; j < i + 10; j++) {
        bit |= map[s.charAt(j) - 'A'];
        bit <<= 2;
      }

      if(!found.add(bit) && added.add(bit)) {
        res.add(s.substring(i, i + 10));
      }
    }

    return res;
  }
}

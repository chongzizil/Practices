package com.zil.li.hashtable;

import java.util.*;

/**
 * Created by youlongli on 2/28/15.
 *
 * https://leetcode.com/problems/repeated-dna-sequences/
 *
 * Idea: Check every possible 10 char long string and add to the map.
 *       The key idea is to transfer the string to int inorder to save space.
 *       Also use two set can speed up the process. Otherwise using a map to count is ok, though need time to iterate the map.
 */
public class RepeatedDNASequences {
  public List<String> findRepeatedDnaSequences(String s) {
    List<String> res = new ArrayList<>();
    Set<Integer> found = new HashSet<>();
    Set<Integer> added = new HashSet<>();

    // Key: char, Value: 2 bit value
    Map<Character, Integer> map = new HashMap<>();
    map.put('A', 0);
    map.put('C', 1);
    map.put('G', 2);
    map.put('T', 3);

    for (int i = 0; i < s.length() - 9; i++) {
      int key = 0;
      for (int j = 0; j < 10; j++) {
        key = key | (map.get(s.charAt(i + j)) << (2 * j));
      }
      if (!found.add(key)) {
        if (added.add(key)) {
          res.add(s.substring(i, i + 10));
        }
      }
    }

    return res;
  }
}

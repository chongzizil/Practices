package com.zil.li.BFSDFS;

import java.util.*;

/**
 * Created by youlongli on 3/6/15.
 *
 * https://oj.leetcode.com/problems/word-ladder-ii/
 *
 * Ref: http://www.cnblogs.com/yuzhangcmu/p/4119492.html
 */
public class WordLadderII {
  public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    if (start == null || end == null || dict == null) {
      return new ArrayList<List<String>>();
    }

    // Key: word, Value: all possible path to that word (should has same length)
    Map<String, List<List<String>>> map = new HashMap<String, List<List<String>>>();
    // Store the paths of each words in the current level
    Map<String, List<List<String>>> mapCurr = new HashMap<String, List<List<String>>>();
    // For BFS
    Deque<String> queue = new ArrayDeque<String>();
    queue.addLast(start);

    // Set initial path
    List<String> path = new ArrayList<String>();
    List<List<String>> paths = new ArrayList<List<String>>();
    path.add(start);
    paths.add(path);
    map.put(start, paths);

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        String str = queue.pollFirst();

        for (int j = 0; j < str.length(); j++) {
          StringBuilder sb = new StringBuilder(str);

          for (char c = 'a'; c <= 'z'; c++) {
            sb.setCharAt(j, c);
            String tmp = sb.toString();

            // The word should be either in the dict or equals to end
            // Plus the map should not contains the word in the previous level, it's used to check if the word is visited
            if ((!dict.contains(tmp) && !tmp.equals(end)) || map.containsKey(tmp)) {
              continue;
            }

            // Get the previous level paths of the word
            List<List<String>> prevPaths = map.get(str);
            // Get the current level paths of the mutated word
            List<List<String>> currPaths = mapCurr.get(tmp);

            // Initialize current paths if the it's null
            if (currPaths == null) {
              currPaths = new ArrayList<List<String>>();
              queue.add(tmp); // Since it's the first time to visit the word, add to the queue
              mapCurr.put(tmp, currPaths); // Add to the current map
            }

            // Update the current path based on all previous paths
            for (List<String> prevPath : prevPaths) {
              List<String> currPath = new ArrayList<String>(prevPath);
              currPath.add(tmp);
              currPaths.add(currPath);
            }
          }
        }
      }

      // When the level finished, check if the end word is found
      if (mapCurr.containsKey(end)) {
        return mapCurr.get(end);
      }

      // If not, update the map and process to next level
      map.putAll(mapCurr);
    }

    // No solution...
    return new ArrayList<List<String>>();
  }
}

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
  public List<List<String>> findLaddersA(String start, String end, Set<String> dict) {
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

  /**
   * First use BFS and then use DFS
   */
  public List<List<String>> findLaddersB(String start, String end, Set<String> dict) {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    // Key: word, value: list of previous words on the path
    Map<String, List<String>> prevWordMap = new HashMap<>();
    Map<String, Integer> minLength = new HashMap<>();

    bfs(prevWordMap, minLength, start, end, dict);

    path.add(end);
    dfs(res, path, prevWordMap, minLength, start);

    return res;
  }

  private void dfs(List<List<String>> res, List<String> path, Map<String, List<String>> map, Map<String, Integer> distance, String start) {
    String currWord = path.get(path.size() - 1);
    if (currWord.equals(start)) { // Get the whole path from start to end.
      Collections.reverse(path);
      res.add(new ArrayList<String>(path));
      Collections.reverse(path);
    } else {
      List<String> prevWords = map.get(currWord);
      for (String prevWord : prevWords) {
        // Make sure the two words min distance are diff by 1, which means it's a shortest path, otherwise skip.
        if (distance.get(prevWord) + 1 != distance.get(currWord)) {
          continue;
        }
        path.add(prevWord);
        dfs(res, path, map, distance, start); // Backtracking
        path.remove(path.size() - 1);
      }
    }
  }

  // Use BFS to get each word's previous word list and also the min distance for each word.
  private void bfs(Map<String, List<String>> map, Map<String, Integer> distance, String start, String end, Set<String> dict) {
    Queue<String> queue = new LinkedList<>();
    queue.add(start);
    dict.add(start);
    dict.add(end);
    distance.put(start, 1);

    for (String word : dict) {
      map.put(word, new ArrayList<String>());
    }

    while(!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String currWord = queue.poll();
        List<String> nextWords = getNextWords(dict, currWord); // Get next step word list
        for (String nextWord : nextWords) {
          map.get(nextWord).add(currWord); // Update the current word as one of the previous word of the next word
          if (!distance.containsKey(nextWord)) { // First time see the word, also used to check if it's visited
            distance.put(nextWord, distance.get(currWord) + 1); // Update the word's min distance
            queue.offer(nextWord); // Add to the queue
          }
        }
      }
    }
  }

  private List<String> getNextWords(Set<String> dict, String word) {
    List<String> nextWords = new ArrayList<>();

    for (int i = 0; i < word.length(); i++) {
      for (char c = 'a'; c <= 'z'; c++) {
        String tmp = word.substring(0, i) + c + word.substring(i + 1);
        if (dict.contains(tmp)) {
          nextWords.add(tmp);
        }
      }
    }

    return nextWords;
  }
}

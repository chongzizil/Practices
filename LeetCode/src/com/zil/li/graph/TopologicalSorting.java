package com.zil.li.graph;

import java.util.*;

import com.zil.li.datastructure.DirectedGraphNode;

/**
 * Created by youlongli on 4/4/15.
 *
 * http://www.lintcode.com/en/problem/topological-sorting/
 */
public class TopologicalSorting {
  /**
   * Idea: Use a map to count the inbound times. Due to the definition of topological order,
   * We only add a node to the result list if all nodes connecting to it are added before.
   *
   * @return: Any topological order for the given graph.
   */
  public List<DirectedGraphNode> topSort(List<DirectedGraphNode> graph) {
    // Key: Graph node, Value: Inbound count
    Map<DirectedGraphNode, Integer> map = new HashMap<>();
    List<DirectedGraphNode> res = new ArrayList<>();
    Queue<DirectedGraphNode> queue = new LinkedList<>();

    // Count all inbound times first.
    for (DirectedGraphNode node : graph) {
      for (DirectedGraphNode child : node.neighbors) {
        if (map.containsKey(child)) {
          map.put(child, map.get(child) + 1);
        } else {
          map.put(child, 1);
        }

      }
    }

    // For nodes with no inbound connect, order is not important, just add to the list
    for (DirectedGraphNode node : graph) {
      if (!map.containsKey(node)) {
        res.add(node);
        queue.offer(node);
      }
    }

    // Use a queue as bfs
    while (!queue.isEmpty()) {
      DirectedGraphNode node = queue.poll();
      // Since the node is added, update the count of all it's children
      for (DirectedGraphNode child : node.neighbors) {
        map.put(child, map.get(child) - 1);
        // The node is now clear for adding
        if (map.get(child) == 0) {
          res.add(child);
          queue.offer(child);
        }
      }
    }

    return res;
  }
}

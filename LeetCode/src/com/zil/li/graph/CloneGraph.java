package com.zil.li.graph;

import com.zil.li.datastructure.UndirectedGraphNode;

import java.util.*;

/**
 * Created by youlongli on 2/28/15.
 *
 * https://leetcode.com/problems/clone-graph/
 */
public class CloneGraph {
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    // Key: Original, Value: Clone
    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    Queue<UndirectedGraphNode> queue = new LinkedList<>();

    if (node == null) {
      return null;
    }

    queue.offer(node);
    map.put(node, new UndirectedGraphNode(node.label));

    while (!queue.isEmpty()) {
      UndirectedGraphNode original = queue.poll();
      UndirectedGraphNode cloned = map.get(original);

      for (UndirectedGraphNode neighbor : original.neighbors) {
        if (!map.containsKey(neighbor)) {
          // First seen, clone and add to queue.
          map.put(neighbor, new UndirectedGraphNode(neighbor.label));
          queue.offer(neighbor);
        }

        cloned.neighbors.add(map.get(neighbor));
      }
    }

    return map.get(node);
  }

  public UndirectedGraphNode solutionB(UndirectedGraphNode node) {
    if (node == null) {
      return null;
    }

    List<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    int start = 0;

    nodes.add(node);
    map.put(node, new UndirectedGraphNode(node.label));

    while (start < nodes.size()) {
      UndirectedGraphNode currNode = nodes.get(start++);
      for (UndirectedGraphNode neighborNode : currNode.neighbors) {
        if (!map.containsKey(neighborNode)) {
          nodes.add(neighborNode);
          map.put(neighborNode, new UndirectedGraphNode(neighborNode.label));
        }
      }
    }

    for (UndirectedGraphNode oldNode : nodes) {
      for (UndirectedGraphNode neighborNode : oldNode.neighbors) {
        map.get(oldNode).neighbors.add(map.get(neighborNode));
      }
    }

    return map.get(node);
  }
}

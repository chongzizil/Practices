package com.zil.li.graph;

import com.zil.li.datastructure.UndirectedGraphNode;

import java.util.*;

/**
 * Created by youlongli on 2/28/15.
 *
 * https://leetcode.com/problems/clone-graph/
 */
public class CloneGraph {
  public UndirectedGraphNode solutionA(UndirectedGraphNode node) {
    // Key: original, Value: copy
    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();

    if (node == null) {
      return node;
    }

    queue.offer(node);
    map.put(node, new UndirectedGraphNode(node.label));

    while (!queue.isEmpty()) {
      UndirectedGraphNode origin = queue.poll();
      UndirectedGraphNode copy = map.get(origin);

      for (UndirectedGraphNode child : origin.neighbors) {
        if (map.containsKey(child)) {
          copy.neighbors.add(map.get(child));
        } else {
          queue.offer(child);

          UndirectedGraphNode childCopy = new UndirectedGraphNode(child.label);
          copy.neighbors.add(childCopy);
          map.put(child, childCopy);
        }

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

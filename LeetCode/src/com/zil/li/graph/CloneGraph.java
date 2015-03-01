package com.zil.li.graph;

import com.zil.li.datastructure.UndirectedGraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by youlongli on 2/28/15.
 */
public class CloneGraph {
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
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

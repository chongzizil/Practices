import datastructure.DirectedEdge;
import datastructure.MyLinkedListGraph;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by youlongli on 4/11/15.
 */
public class Dijkstra {
  private class PQNode implements Comparable {
    int v;
    double dist;

    public PQNode(int v, double dist) {
      this.v = v;
      this.dist = dist;
    }

    @Override
    public int compareTo(Object o) {
      PQNode that = (PQNode) o;
      return (int) (this.dist - that.dist);
    }
  }

  Map<Integer, PQNode> table;
  PriorityQueue<PQNode> pq;
  DirectedEdge[] edgeTo;
  double[] distTo;

  public double shortestPath(MyLinkedListGraph graph, int start, int end) {
    pq = new PriorityQueue<>();
    table = new HashMap<>();
    edgeTo = new DirectedEdge[graph.V()];
    distTo = new double[graph.V()];

    for (int v = 0; v < graph.V(); v++) {
      distTo[v] = Integer.MAX_VALUE;
    }
    distTo[start] = 0;

    pq.offer(new PQNode(start, distTo[start]));

    while (!pq.isEmpty()) {
      relax(graph, pq.poll().v);
    }

    return distTo[end];
  }

  private void relax(MyLinkedListGraph graph, int v) {
    for (DirectedEdge edge : graph.adj(v)) {
      int w = edge.to();
      if (distTo[w] > distTo[v] + edge.weight()) {
        distTo[w] = distTo[v] + edge.weight();
        edgeTo[w] = edge;
        if (pq.contains(w)) {
          pq.remove(table.get(w));
          table.remove(w);
          PQNode node = new PQNode(w, distTo[w]);
          pq.offer(node);
          table.put(w, node);
        } else {
          PQNode node = new PQNode(w, distTo[w]);
          pq.offer(node);
          table.put(w, node);
        }
      }
    }
  }
}

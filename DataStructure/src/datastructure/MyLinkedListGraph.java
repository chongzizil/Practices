package datastructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by youlongli on 4/11/15.
 */
public class MyLinkedListGraph {
  private final int V;
  private int E;
  private LinkedList<DirectedEdge>[] adj;

  public MyLinkedListGraph(int V) {
    this.V = V;
    this.E = 0;
    adj = new LinkedList[V];
    for (int v = 0; v < V; v++) {
      adj[v] = new LinkedList<>();
    }
  }

  public int V() {
    return V;
  }

  public int E() {
    return 0;
  }

  public void addEdge(int v, int w, int weight) {
    DirectedEdge edge = new DirectedEdge(v, w, weight);
    adj[v].add(edge);
    E++;
  }

  public List<DirectedEdge> adj(int v) {
    return adj[v];
  }
}

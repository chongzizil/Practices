import datastructure.MyLinkedListGraph;
import org.junit.Test;

import static org.junit.Assert.*;

public class DijkstraTest {
  Dijkstra dijkstra = new Dijkstra();

  @Test
  public void testShortestPath() throws Exception {
    MyLinkedListGraph graph = new MyLinkedListGraph(7);
    graph.addEdge(1, 2, 7);
    graph.addEdge(2, 1, 7);
    graph.addEdge(1, 3, 9);
    graph.addEdge(3, 1, 9);
    graph.addEdge(1, 6, 14);
    graph.addEdge(6, 1, 14);
    graph.addEdge(2, 3, 10);
    graph.addEdge(3, 2, 10);
    graph.addEdge(3, 6, 2);
    graph.addEdge(6, 3, 2);
    graph.addEdge(2, 4, 15);
    graph.addEdge(4, 2, 15);
    graph.addEdge(3, 4, 11);
    graph.addEdge(4, 3, 11);
    graph.addEdge(5, 5, 6);
    graph.addEdge(4, 4, 6);
    graph.addEdge(5, 6, 9);
    graph.addEdge(6, 5, 9);

    assertEquals(7.0, dijkstra.shortestPath(graph, 1, 2), 0.001);
    assertEquals(9.0, dijkstra.shortestPath(graph, 1, 3), 0.001);
    assertEquals(20.0, dijkstra.shortestPath(graph, 1, 4), 0.001);
    assertEquals(20.0, dijkstra.shortestPath(graph, 1, 5), 0.001);
    assertEquals(11.0, dijkstra.shortestPath(graph, 1, 6), 0.001);
  }
}
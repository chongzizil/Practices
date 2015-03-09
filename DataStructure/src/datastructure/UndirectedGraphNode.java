package datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 2/28/15.
 */
public class UndirectedGraphNode {
  public int label;
  public List<UndirectedGraphNode> neighbors;

  public UndirectedGraphNode(int x) {
    label = x;
    neighbors = new ArrayList<UndirectedGraphNode>();
  }
}

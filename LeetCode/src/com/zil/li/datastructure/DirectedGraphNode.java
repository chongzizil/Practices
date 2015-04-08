package com.zil.li.datastructure;

/**
 * Created by youlongli on 4/4/15.
 */

import java.util.ArrayList;
import java.util.List;

public class DirectedGraphNode {
  public int label;
  public List<DirectedGraphNode> neighbors;

  public DirectedGraphNode(int x) {
    label = x;
    neighbors = new ArrayList<DirectedGraphNode>();
  }
};

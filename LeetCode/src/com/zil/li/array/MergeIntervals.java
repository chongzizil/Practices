package com.zil.li.array;


import com.zil.li.datastructure.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by youlongli on 3/8/15.
 *
 * https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {
  private Comparator<Interval> comparator = new Comparator<Interval>() {
    public int compare(Interval i1, Interval i2) {
      return i1.start - i2.start;
    }
  };

  public List<Interval> merge(List<Interval> intervals) {
    List<Interval> res = new ArrayList<Interval>();

    if (intervals == null || intervals.size() == 0) {
      return res;
    }

    // Do not forget the comparator.
    Collections.sort(intervals, comparator);

    Interval last = intervals.get(0);
    for (int i = 1; i < intervals.size(); i++) {
      Interval curr = intervals.get(i);
      if (curr.start <= last.end) {
        // Merge.
        last.end = Math.max(curr.end, last.end);
      } else {
        res.add(last);
        last = curr;
      }
    }

    res.add(last);
    return res;
  }
}

package com.zil.li.array;

import com.zil.li.datastructure.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 3/8/15.
 *
 * https://leetcode.com/problems/insert-interval/
 */
public class InsertInterval {
  /**
   * 3 while loop for 3 conditions. (intervals must be sorted.)
   */
  public List<Interval> solutionA(List<Interval> intervals, Interval newInterval) {
    if (intervals == null ||newInterval == null) {
      return intervals;
    }

    List<Interval> res = new ArrayList<Interval>();
    int i = 0;

    while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
      res.add(intervals.get(i++));
    }

    while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
      newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
      newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
      i++;
    }

    res.add(newInterval);

    while (i < intervals.size()) {
      res.add(intervals.get(i++));
    }

    return res;
  }

  public List<Interval> solutionB(List<Interval> intervals, Interval newInterval) {
    if (intervals == null ||newInterval == null) {
      return intervals;
    }

    List<Interval> res = new ArrayList<Interval>();
    int insertPos = 0;

    for (Interval interval : intervals) {
      if (interval.end < newInterval.start) {
        res.add(interval);
        insertPos++;
      } else if (interval.start > newInterval.end) {
        res.add(interval);
      } else {
        newInterval.start = Math.min(newInterval.start, interval.start);
        newInterval.end = Math.max(newInterval.end, interval.end);
      }
    }

    res.add(insertPos, newInterval);

    return res;
  }
}

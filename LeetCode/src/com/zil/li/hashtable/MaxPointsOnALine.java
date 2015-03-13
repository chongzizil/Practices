package com.zil.li.hashtable;

import com.zil.li.datastructure.Point;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by youlongli on 3/11/15.
 *
 * https://leetcode.com/problems/max-points-on-a-line/
 */
public class MaxPointsOnALine {
  public int maxPoints(Point[] points) {
    int res = 0;

    // Check every point
    for (int i = 0; i < points.length; i++) {
      Map<Double, Integer> map = new HashMap<Double, Integer>();
      int dup = 0;

      // Check the k of all the lines between ith point and jth point
      for (int j = i; j < points.length; j++) {
        // Same point
        if (points[i].x == points[j].x && points[i].y == points[j].y) {
          dup++;
          continue;
        }

        // Default when points[i].x == points[j].x where k is infinity
        double k = Double.MAX_VALUE;
        if (points[i].x != points[j].x) {
          k = 0.0 + // prevent k to be -0.0... Interesting...
              (double)(points[i].y - points[j].y) / (double)(points[i].x - points[j].x);
        }

        // Add to map.
        if (map.containsKey(k)) {
          map.put(k, map.get(k) + 1);
        } else {
          map.put(k, 1);
        }
      }

      // In case all the other points are as same as point i
      res = Math.max(res, dup);
      for (double key : map.keySet()) {
        res = Math.max(res, dup + map.get(key));
      }
    }

    return res;
  }
}

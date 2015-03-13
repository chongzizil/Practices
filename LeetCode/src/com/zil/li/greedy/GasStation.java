package com.zil.li.greedy;

/**
 * Created by youlongli on 3/11/15.
 *
 * https://leetcode.com/problems/gas-station/
 */
public class GasStation {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int total = 0; // Total gas
    int curr = 0; // Current gas
    int res = 0;

    for (int i = 0; i < gas.length; i++) {
      if (curr < 0) {
        curr = 0; // Previous station is invalid, update to this one
        res = i;
      }

      curr += gas[i] - cost[i];
      total += gas[i] - cost[i];
    }

    if (total < 0) {
      return -1; // Total gas is not enough, it's impossible
    } else {
      return res;
    }
  }
}

package com.zil.li;

import com.zil.li.DP.BestTimeToBuyAndSellStockIII;
import com.zil.li.DP.DecodeWays;
import com.zil.li.DP.WordBreakII;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by youlongli on 12/30/14.
 */
public class Main {
  public static void main(String[] args) throws IOException {
    BestTimeToBuyAndSellStockIII test = new BestTimeToBuyAndSellStockIII();
    System.out.println(test.maxProfit(new int[]{5, -10, -20, -30, 4}));
  }

}

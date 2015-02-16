package com.zil.li.DP;

/**
 * Created by youlongli on 2/4/15.
 */
public class DungeonGame {
  /**
   * The idea is to use DP, instead of starting from the start position, we should start from
   * the destination.
   */
  public int calculateMinimumHP(int[][] dungeon) {
    int row = dungeon.length;
    int col = dungeon[0].length;
    int[][] minimalHP = new int[row][col];

    for (int i = row - 1; i >= 0; i--) {
      for (int j = col - 1; j >= 0; j--) {
        if (i == row - 1 && j == col - 1) {
          minimalHP[i][j] = Math.max(1, 1 - dungeon[i][j]);
        } else if (i == row - 1) {
          minimalHP[i][j] = Math.max(1, minimalHP[i][j + 1] - dungeon[i][j]);
        } else if (j == col - 1) {
          minimalHP[i][j] = Math.max(1, minimalHP[i + 1][j] - dungeon[i][j]);
        } else {
          minimalHP[i][j] =
              Math.max(1, Math.min(minimalHP[i][j + 1], minimalHP[i + 1][j]) - dungeon[i][j]);
        }
      }
    }

    return minimalHP[0][0];
  }
}

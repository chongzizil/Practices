package deckofcards;

import java.util.List;

/**
 * Created by youlongli on 4/16/15.
 */
public class Main {
  public static void main(String[] args) {
    int numHands = 5;
    BlackJack game = new BlackJack(numHands);

    game.initializeDeck();
    boolean success = game.dealInitial();

    if (!success) {
      System.out.println("Error. Out of cards.");
    } else {
      System.out.println("-- Initial --");
      game.printHandsAndScore();
      List<Integer> blackjacks = game.getBlackJacks();
      if (blackjacks.size() > 0) {
        System.out.print("Blackjack at ");
        for (int i : blackjacks) {
          System.out.print(i + ", ");
        }
        System.out.println("");
      } else {
        success = game.playAllHands();
        if (!success) {
          System.out.println("Error. Out of cards.");
        } else {
          System.out.println("\n-- Completed Game --");
          game.printHandsAndScore();
          List<Integer> winners = game.getWinners();
          if (winners.size() > 0) {
            System.out.print("Winners: ");
            for (int i : winners) {
              System.out.print(i + ", ");
            }
            System.out.println("");
          } else {
            System.out.println("Draw. All players have busted.");
          }
        }
      }
    }
  }
}

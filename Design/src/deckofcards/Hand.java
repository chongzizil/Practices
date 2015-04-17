package deckofcards;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by youlongli on 4/15/15.
 */
public class Hand<T extends Card> {
  List<T> cards;

  public Hand() {
    cards = new LinkedList<>();
  }

  public int score() {
    int score = 0;
    for (T card : cards) {
      score += card.getValue();
    }
    return score;
  }

  public void addCard(T card) {
    cards.add(card);
  }

  public void print() {
    for (Card card : cards) {
      System.out.println(card.toString());
    }
  }
}

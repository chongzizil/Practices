package deckofcards;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by youlongli on 4/15/15.
 */
public class Deck<T extends Card> {
  private List<T> cards;
  private int dealtIndex = 0;

  public void Deck() {
  }

  public void setDeckOfCards(List<T> cards) {
    this.cards = new LinkedList<>(cards);
  }

  public void shuffle() {
    int cardNum = 52;
    for (int i = 1; i < cardNum; i++) {
      shuffle(i);
    }
  }

  private void shuffle(int i) {
    Random rnd = new Random();
    int randomIndex = rnd.nextInt(i);
    swap(randomIndex, i);
  }

  private void swap(int i, int j) {
    T tmp = cards.get(i);
    cards.set(i, cards.get(j));
    cards.set(j, tmp);
  }

  public int remainingCards() {
    return cards.size() - dealtIndex;
  }

  public T dealtCard() {
    return cards.get(dealtIndex++);
  }
}

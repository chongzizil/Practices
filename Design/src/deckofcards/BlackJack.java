package deckofcards;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 4/15/15.
 */
public class BlackJack {
  private Deck<BlackJackCard> deck;
  private BlackJackHand[] hands;
  private static final int HIT_UNTIL = 16;

  public BlackJack(int numPlayers) {
    hands = new BlackJackHand[numPlayers];
    for (int i = 0; i < numPlayers; i++) {
      hands[i] = new BlackJackHand();
    }
  }

  public boolean dealInitial() {
    for (BlackJackHand hand : hands) {
      BlackJackCard card1 = deck.dealtCard();
      BlackJackCard card2 = deck.dealtCard();
      if (card1 == null || card2 == null) {
        return false;
      }
      hand.addCard(card1);
      hand.addCard(card2);
    }
    return true;
  }

  public List<Integer> getBlackJacks() {
    List<Integer> winners = new ArrayList<>();
    for (int i = 0; i < hands.length; i++) {
      if (hands[i].isBlackJack()) {
        winners.add(i);
      }
    }
    return winners;
  }

  public boolean playHand(int player) {
    BlackJackHand hand = hands[player];
    return playHand(hand);
  }

  public boolean playHand(BlackJackHand hand) {
    while (hand.score() < HIT_UNTIL) {
      BlackJackCard card = deck.dealtCard();
      if (card == null) {
        return false;
      }
      hand.addCard(card);
    }
    return true;
  }

  public boolean playAllHands() {
    for (BlackJackHand hand : hands) {
      if (!playHand(hand)) {
        return false;
      }
    }
    return true;
  }

  public List<Integer> getWinners() {
    List<Integer> winners = new ArrayList<>();
    int winningScore = 0;
    for (int i = 0; i < hands.length; i++) {
      BlackJackHand hand = hands[i];
      if (!hand.isBusted()) {
        if (hand.score() > winningScore) {
          winningScore = hand.score();
          winners.clear();;
          winners.add(i);
        } else if (hand.score() == winningScore) {
          winners.add(i);
        }
      }
    }
    return winners;
  }

  public void initializeDeck() {
    List<BlackJackCard> cards = new ArrayList<>();
    for (BlackJackCard.Suit suit : BlackJackCard.Suit.values()) {
      for (BlackJackCard.Rank rank : BlackJackCard.Rank.values()) {
        BlackJackCard card = new BlackJackCard(suit, rank);
        cards.add(card);
      }
    }
    deck = new Deck<>();
    deck.setDeckOfCards(cards);
    deck.shuffle();
  }

  public void printHandsAndScore() {
    for (int i = 0; i < hands.length; i++) {
      System.out.print("Hand " + i + " (" + hands[i].score() + "): ");
      hands[i].print();
      System.out.println("");
    }
  }
}

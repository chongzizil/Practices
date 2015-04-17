package deckofcards;

/**
 * Created by youlongli on 4/15/15.
 */
public abstract class Card {
  public enum Suit {
    CLUB,
    DIAMOND,
    HEART,
    SPADE
  }

  public enum Rank {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING
  }

  protected final Suit suit;
  protected final Rank rank;

  public Card(Suit suit, Rank rank) {
    this.suit = suit;
    this.rank = rank;
  }

  public Suit getSuit() {
    return suit;
  }

  public Rank getRank() {
    return rank;
  }

  public int getValue() {
    return rank.ordinal() + 1;
  }

  @Override
  public String toString() {
    if (getValue() <= 10) {
      return suit.name().substring(0, 1) + getValue();
    }

    return  suit.name().substring(0, 1) + rank.name().substring(0, 1);
  }
}

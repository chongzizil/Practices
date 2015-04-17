package deckofcards;

/**
 * Created by youlongli on 4/15/15.
 */
public class BlackJackCard extends Card {

  public BlackJackCard(Suit suit, Rank rank) {
    super(suit, rank);
  }

  @Override
  public int getValue() {
    if (isAce()) {
      return 1;
    } else if (isFaceCard()) {
      return 10;
    }

    return super.getValue();
  }

  public int minValue() {
    if (isAce()) {
      return 1;
    }
    return getValue();
  }

  public int maxValue() {
    if (isAce()) {
      return 11;
    }
    return getValue();
  }

  public boolean isAce() {
    return rank == Rank.ACE;
  }

  public boolean isFaceCard() {
    return super.getValue() >= 10 && super.getValue() <= 12;
  }
}

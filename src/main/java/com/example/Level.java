package com.example;

import com.example.verifier.*;

public enum Level {
  STRAIGHT_FLUSH(
      "Straight flush", 9, new StraightFlushVerifier(new FlushVerifier(), new StraightVerifier())),
  FOUR_OF_A_KIND("Four of a kind", 8, new FourOfAKindVerifier()),
  FULL_HOUSE("Full House", 7, new FullHouseVerifier()),
  FLUSH("Flush", 6, new FlushVerifier()),
  STRAIGHT("Straight", 5, new StraightVerifier()),
  THREE_OF_KIND("Three of a kind", 4, new ThreeOfAKindVerifier()),
  TWO_PAIRS("Two Pairs", 3, new TwoPairsVerifier()),
  PAIR("Pair", 2, new HighCardVerifier()),
  HIGH_CARD("High card", 1, new HighCardVerifier());

  private String kind;
  private int level;
  private CardTypeVerifier cardTypeVerifier;

  Level(String kind, int level, CardTypeVerifier cardTypeVerifier) {
    this.kind = kind;
    this.level = level;
    this.cardTypeVerifier = cardTypeVerifier;
  }

  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public CardTypeVerifier getCardTypeVerifier() {
    return cardTypeVerifier;
  }

  public void setCardTypeVerifier(CardTypeVerifier cardTypeVerifier) {
    this.cardTypeVerifier = cardTypeVerifier;
  }
}

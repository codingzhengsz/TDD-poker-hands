package com.example.verifier;

import com.example.PokerHands;

public class StraightFlushVerifier implements CardTypeVerifier {
  private CardTypeVerifier flushVerifier;
  private CardTypeVerifier straightFlushVerifier;

  public StraightFlushVerifier(
      CardTypeVerifier flushVerifier, CardTypeVerifier straightFlushVerifier) {
    this.flushVerifier = flushVerifier;
    this.straightFlushVerifier = straightFlushVerifier;
  }

  @Override
  public boolean verify(PokerHands pokerHands) {
    return flushVerifier.verify(pokerHands) && straightFlushVerifier.verify(pokerHands);
  }
}

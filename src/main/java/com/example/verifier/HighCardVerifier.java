package com.example.verifier;

import com.example.PokerHands;

public class HighCardVerifier implements CardTypeVerifier {
  @Override
  public boolean verify(PokerHands pokerHands) {
    return true;
  }
}

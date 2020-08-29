package com.example.verifier;

import com.example.PokerHands;

import static com.example.util.VerifyUtil.isFourOfAKind;

public class FourOfAKindVerifier implements CardTypeVerifier {
  @Override
  public boolean verify(PokerHands pokerHands) {
    return isFourOfAKind(0, pokerHands.getPokers()) || isFourOfAKind(1, pokerHands.getPokers());
  }
}

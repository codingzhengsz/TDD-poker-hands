package com.example.verifier;

import com.example.PokerHands;

import static com.example.util.VerifyUtil.isThreeOfAKind;

public class ThreeOfAKindVerifier implements CardTypeVerifier {
  @Override
  public boolean verify(PokerHands pokerHands) {
    return isThreeOfAKind(0, pokerHands.getPokers())
        || isThreeOfAKind(1, pokerHands.getPokers())
        || isThreeOfAKind(2, pokerHands.getPokers());
  }
}

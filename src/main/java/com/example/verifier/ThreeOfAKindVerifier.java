package com.example.verifier;

import com.example.PokerHands;

import static com.example.util.VerifyUtil.isThreeOfKind;

public class ThreeOfAKindVerifier implements CardTypeVerifier {
  @Override
  public boolean verify(PokerHands pokerHands) {
    return isThreeOfKind(0, pokerHands.getPokers())
        || isThreeOfKind(1, pokerHands.getPokers())
        || isThreeOfKind(2, pokerHands.getPokers());
  }
}

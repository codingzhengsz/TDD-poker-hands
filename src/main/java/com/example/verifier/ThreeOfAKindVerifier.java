package com.example.verifier;

import com.example.Poker;
import com.example.PokerHands;

import java.util.List;

public class ThreeOfAKindVerifier implements CardTypeVerifier {
  @Override
  public boolean verify(PokerHands pokerHands) {
    return isThreeOfKind(0, pokerHands.getPokers())
        || isThreeOfKind(1, pokerHands.getPokers())
        || isThreeOfKind(2, pokerHands.getPokers());
  }

  private boolean isThreeOfKind(int startIndex, List<Poker> pokerList) {
    return pokerList.get(startIndex).getValue() == pokerList.get(startIndex + 1).getValue()
        && pokerList.get(startIndex + 1).getValue() == pokerList.get(startIndex + 2).getValue();
  }
}

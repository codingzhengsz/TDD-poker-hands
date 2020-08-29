package com.example.verifier;

import com.example.Poker;
import com.example.PokerHands;

import java.util.List;

public class FourOfAKindVerifier implements CardTypeVerifier {
  @Override
  public boolean verify(PokerHands pokerHands) {
    return isFourOfAKind(0, pokerHands.getPokers()) || isFourOfAKind(1, pokerHands.getPokers());
  }

  private boolean isFourOfAKind(int startIndex, List<Poker> pokerList) {
    return pokerList.get(startIndex).getValue() == pokerList.get(startIndex + 1).getValue()
        && pokerList.get(startIndex + 1).getValue() == pokerList.get(startIndex + 2).getValue()
        && pokerList.get(startIndex + 2).getValue() == pokerList.get(startIndex + 3).getValue();
  }
}

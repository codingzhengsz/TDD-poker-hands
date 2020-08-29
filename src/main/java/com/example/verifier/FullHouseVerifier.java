package com.example.verifier;

import com.example.Poker;
import com.example.PokerHands;

import java.util.List;

public class FullHouseVerifier implements CardTypeVerifier {
  @Override
  public boolean verify(PokerHands pokerHands) {
    return isFullHouse(pokerHands.getPokers());
  }

  private boolean isFullHouse(List<Poker> pokerList) {
    return isThreeOfKind(0, pokerList) && isPair(3, pokerList)
        || isPair(0, pokerList) && isThreeOfKind(2, pokerList);
  }

  private boolean isThreeOfKind(int startIndex, List<Poker> pokerList) {
    return pokerList.get(startIndex).getValue() == pokerList.get(startIndex + 1).getValue()
        && pokerList.get(startIndex + 1).getValue() == pokerList.get(startIndex + 2).getValue();
  }

  private boolean isPair(int startIndex, List<Poker> pokerList) {
    return pokerList.get(startIndex).getValue() == pokerList.get(startIndex + 1).getValue();
  }
}

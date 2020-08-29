package com.example.verifier;

import com.example.Poker;
import com.example.PokerHands;

import java.util.List;

public class TwoPairsVerifier implements CardTypeVerifier {
  @Override
  public boolean verify(PokerHands pokerHands) {
    List<Poker> pokerList = pokerHands.getPokers();
    return (isPair(1, pokerList) && isPair(3, pokerList))
        || (isPair(0, pokerList) && isPair(3, pokerList))
        || isPair(0, pokerList) && isPair(2, pokerList);
  }

  private boolean isPair(int startIndex, List<Poker> pokerList) {
    return pokerList.get(startIndex).getValue() == pokerList.get(startIndex + 1).getValue();
  }
}

package com.example.verifier;

import com.example.Poker;
import com.example.PokerHands;

import java.util.List;

public class StraightVerifier implements CardTypeVerifier {
  @Override
  public boolean verify(PokerHands pokerHands) {
    List<Poker> pokerList = pokerHands.getPokers();
    boolean isStraight = true;
    int endIndex = pokerList.size() - 1;
    if (pokerList.get(4).getValue() == 14 && pokerList.get(0).getValue() == 2) {
      endIndex -= 1;
    }
    for (int i = 1; i <= endIndex; i++) {
      if (pokerList.get(i).getValue() - 1 != pokerList.get(i - 1).getValue()) {
        isStraight = false;
        break;
      }
    }
    return isStraight;
  }
}

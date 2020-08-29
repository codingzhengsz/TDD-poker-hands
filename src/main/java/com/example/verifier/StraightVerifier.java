package com.example.verifier;

import com.example.Poker;
import com.example.PokerHands;

import java.util.List;

public class StraightVerifier implements CardTypeVerifier {
  @Override
  public boolean verify(PokerHands pokerHands) {
    List<Poker> pokerList = pokerHands.getPokers();
    boolean isStraight = true;
    if (pokerList.get(4).getValue() == 14 && pokerList.get(0).getValue() == 2) {
      return verifyWithAce(pokerHands);
    }
    for (int i = 1; i < pokerList.size(); i++) {
      if (pokerList.get(i).getValue() - 1 != pokerList.get(i - 1).getValue()) {
        isStraight = false;
        break;
      }
    }
    return isStraight;
  }

  boolean verifyWithAce(PokerHands pokerHands) {
    List<Poker> pokerList = pokerHands.getPokers();
    boolean isStraight = true;
    for (int i = 1; i < pokerList.size() - 1; i++) {
      if (pokerList.get(i).getValue() - 1 != pokerList.get(i - 1).getValue()) {
        isStraight = false;
        break;
      }
    }
    if (isStraight) {
      pokerList.get(4).setValue(1);
    }
    return isStraight;
  }
}

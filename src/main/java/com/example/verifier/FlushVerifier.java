package com.example.verifier;

import com.example.Poker;
import com.example.PokerHands;

import java.util.List;

public class FlushVerifier implements CardTypeVerifier {
  @Override
  public boolean verify(PokerHands pokerHands) {
    boolean isFlush = true;
    List<Poker> pokerList = pokerHands.getPokers();
    for (int i = 1; i < pokerList.size(); i++) {
      if (!pokerList.get(0).getKind().equals(pokerList.get(i).getKind())) {
        isFlush = false;
        break;
      }
    }
    return isFlush;
  }
}

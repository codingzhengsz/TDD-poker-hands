package com.example.verifier;

import com.example.Poker;
import com.example.PokerHands;

import java.util.List;

import static com.example.util.VerifyUtil.isPair;
import static com.example.util.VerifyUtil.isThreeOfAKind;

public class FullHouseVerifier implements CardTypeVerifier {
  @Override
  public boolean verify(PokerHands pokerHands) {
    List<Poker> pokerList = pokerHands.getPokers();
    return isThreeOfAKind(0, pokerList) && isPair(3, pokerList)
        || isPair(0, pokerList) && isThreeOfAKind(2, pokerList);
  }
}

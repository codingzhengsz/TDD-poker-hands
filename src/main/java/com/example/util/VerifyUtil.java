package com.example.util;

import com.example.Poker;

import java.util.List;

public class VerifyUtil {

  public static boolean isFourOfAKind(int startIndex, List<Poker> pokerList) {
    return pokerList.get(startIndex).getValue() == pokerList.get(startIndex + 1).getValue()
        && pokerList.get(startIndex + 1).getValue() == pokerList.get(startIndex + 2).getValue()
        && pokerList.get(startIndex + 2).getValue() == pokerList.get(startIndex + 3).getValue();
  }

  public static boolean isThreeOfAKind(int startIndex, List<Poker> pokerList) {
    return pokerList.get(startIndex).getValue() == pokerList.get(startIndex + 1).getValue()
        && pokerList.get(startIndex + 1).getValue() == pokerList.get(startIndex + 2).getValue();
  }

  public static boolean isPair(int startIndex, List<Poker> pokerList) {
    return pokerList.get(startIndex).getValue() == pokerList.get(startIndex + 1).getValue();
  }
}

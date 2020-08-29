package com.example;

import java.util.*;

import static com.example.Level.HIGH_CARD;
import static com.example.constant.CardMapping.of;
import static com.example.constant.CardMapping.to;
import static java.lang.String.valueOf;

public class Game {

  private PokerHands generatePokerHands(String cards) {
    String[] pokers = cards.split(" ");
    PokerHands pokerHands = new PokerHands();
    List<Poker> pokerList = new ArrayList<>();
    pokerHands.setPokers(pokerList);
    for (String pokerStr : pokers) {
      Poker poker = new Poker();
      poker.setValue(to(pokerStr.charAt(0)));
      poker.setKind(valueOf(pokerStr.charAt(1)));
      pokerList.add(poker);
    }
    pokerList.sort(Comparator.comparing(Poker::getValue));
    return pokerHands;
  }

  private Level getLevel(PokerHands pokerHands) {
    for (Level level : Level.values()) {
      if (level.getCardTypeVerifier().verify(pokerHands)) {
        return level;
      }
    }
    return HIGH_CARD;
  }

  public String run(String black, String white) {
    PokerHands blackPokerHands = generatePokerHands(black);
    PokerHands whitePokerHands = generatePokerHands(white);
    return getResult(blackPokerHands, whitePokerHands);
  }

  private String getResult(PokerHands blackPokerHands, PokerHands whitePokerHands) {
    Level blackLevel = getLevel(blackPokerHands);
    Level whiteLevel = getLevel(whitePokerHands);
    if (blackLevel.getLevel() > whiteLevel.getLevel()) {
      return "Black win. - with " + blackLevel.getKind();
    } else if (blackLevel.getLevel() < whiteLevel.getLevel()) {
      return "White win. - with " + whiteLevel.getKind();
    } else {
      return getResultWithSameLevel(blackPokerHands, whitePokerHands);
    }
  }

  private String getResultWithSameLevel(PokerHands blackPokerHands, PokerHands whitePokerHands) {
    HashMap<Integer, Integer> blackPokerMap = calculateCountOfEachKey(blackPokerHands);
    HashMap<Integer, Integer> whitePokerMap = calculateCountOfEachKey(whitePokerHands);
    List<Map.Entry<Integer, Integer>> blackList = new ArrayList<>(blackPokerMap.entrySet());
    List<Map.Entry<Integer, Integer>> whiteList = new ArrayList<>(whitePokerMap.entrySet());
    blackList.sort(Map.Entry.comparingByValue());
    whiteList.sort(Map.Entry.comparingByValue());
    for (int i = blackList.size() - 1; i >= 0; i--) {
      if (blackList.get(i).getKey().equals(whiteList.get(i).getKey())) {
        continue;
      }
      if (blackList.get(i).getKey() < whiteList.get(i).getKey()) {
        return "White win. - with high card " + of(whiteList.get(i).getKey());
      }
      if (blackList.get(i).getKey() > whiteList.get(i).getKey()) {
        return "Black win. - with high card " + of(blackList.get(i).getKey());
      }
    }
    return "Tie";
  }

  private HashMap<Integer, Integer> calculateCountOfEachKey(PokerHands pokerHands) {
    List<Poker> pokerList = pokerHands.getPokers();
    HashMap<Integer, Integer> pokerMap = new HashMap<>();
    for (Poker poker : pokerList) {
      int key = poker.getValue() == 14 ? 1 : poker.getValue();
      if (pokerMap.containsKey(poker.getValue())) {
        pokerMap.put(key, pokerMap.get(key) + 1);
      } else {
        pokerMap.put(key, 1);
      }
    }
    return pokerMap;
  }
}

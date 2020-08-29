package com.example.constant;

import java.util.HashMap;
import java.util.Map;

public enum CardMapping {
  T(10),
  J(11),
  Q(12),
  K(13),
  A(14);

  private int value;

  public static final Map<String, Integer> keyMapping;
  public static final Map<Integer, String> valueMapping;

  static {
    keyMapping = new HashMap<>();
    valueMapping = new HashMap<>();
    for (CardMapping value : CardMapping.values()) {
      keyMapping.put(value.name(), value.getValue());
      valueMapping.put(value.getValue(), value.name());
    }
  }

  CardMapping(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public static int to(char value) {
    String valueStr = String.valueOf(value);
    return keyMapping.containsKey(valueStr) ? keyMapping.get(valueStr) : value - 48;
  }

  public static String of(int value) {
    return valueMapping.containsKey(value) ? valueMapping.get(value) : String.valueOf(value);
  }
}

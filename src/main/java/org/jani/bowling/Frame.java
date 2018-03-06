package org.jani.bowling;

import static java.lang.Integer.parseInt;

class Frame {
  private String first;
  private String second;
  private boolean bonus;

  private static final String SPARE_SIGNAL = "/";

  Frame(String first, String second) {
    this.first = first;
    this.second = second;
  }

  int calculateScore() {
    return isSpare() ? 10 : parseInt(first) + parseInt(second);
  }

  boolean isSpare() {
    return SPARE_SIGNAL.equals(second);
  }

  int getFirstScore() {
    return parseInt(first);
  }

  void setBonus(boolean bonus) {
    this.bonus = bonus;
  }

  boolean isBonus() {
    return bonus;
  }
}

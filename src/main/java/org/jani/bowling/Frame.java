package org.jani.bowling;

import static java.lang.Integer.parseInt;

class Frame {
  private String first;
  private String second;

  private static final String SPARE_SIGNAL = "/";
  private boolean bonus;

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

  public void setBonus(boolean bonus) {
    this.bonus = bonus;
  }

  public boolean isBonus() {
    return bonus;
  }
}

package org.jani.bowling;

import static java.lang.Integer.parseInt;
import static org.jani.bowling.BowlingConstant.EMPTY;
import static org.jani.bowling.BowlingConstant.SPARE_SIGNAL;
import static org.jani.bowling.BowlingConstant.STRIKE_SIGNAL;

class Frame {
  private String first;
  private String second;
  private boolean bonus;
  private String upComingRecords;

  Frame(String first, String second) {
    this.first = first;
    this.second = second;
  }

  int calculateScore() {
    return isSpare() || isStrike() ? 10 : getFirstScore() + getSecondScore(second);
  }

  private int getSecondScore(String second) {
    return "".equals(second) ? 0 : parseInt(second);
  }

  boolean isStrike() {
    return STRIKE_SIGNAL.equals(first);
  }

  boolean isSpare() {
    return SPARE_SIGNAL.equals(second);
  }

  int getFirstScore() {
    return "".equals(first) ? 0 : parseInt(first);
  }

  void setBonus(boolean bonus) {
    this.bonus = bonus;
  }

  boolean isBonus() {
    return bonus;
  }

  void setUpComingRecords(String upComingRecords) {
    this.upComingRecords = upComingRecords;
  }

  int getBonus() {
    String[] bonuses = upComingRecords.split(EMPTY);
    int totalBonus = 0;
    for (String bonus : bonuses) {
      switch (bonus) {
        case "X":
          totalBonus += 10;
          break;
        case "/":
          return 10;
        case "-":
          totalBonus += 0;
          break;
        default:
          totalBonus += parseInt(bonus);
      }
    }
    return totalBonus;
  }
}

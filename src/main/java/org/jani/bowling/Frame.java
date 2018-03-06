package org.jani.bowling;

import static java.lang.Integer.parseInt;

public class Frame {
  private static final String SPARE_SIGNAL = "/";
  private String first;
  private String second;

  public Frame(String first, String second) {
    this.first = first;
    this.second = second;
  }

  public int calculateScore() {
    if (isSpare()) {
      return 10;
    }
    return parseInt(first) + parseInt(second);
  }

  public boolean isSpare() {
    return SPARE_SIGNAL.endsWith(second);
  }

  public int getFirstScore() {
    return parseInt(first);
  }
}

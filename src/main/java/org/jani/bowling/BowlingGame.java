package org.jani.bowling;

import static java.util.Arrays.stream;

class BowlingGame {

  private static final String EMPTY = "";

  int calculateScore(String input) {
    return stream(input.split(EMPTY))
            .mapToInt(Integer::parseInt)
            .sum();
  }
}

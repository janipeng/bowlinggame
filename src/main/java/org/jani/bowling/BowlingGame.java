package org.jani.bowling;

class BowlingGame {

  private static final String EMPTY = "";

  int getScore(String input) {
    String[] records = input.split(EMPTY);
    FramesBuilder framesBuilder = new FramesBuilder();
    BowlingCalculator bowlingCalculator = new BowlingCalculator();
    return bowlingCalculator.calculate(framesBuilder.build(records));
  }


}

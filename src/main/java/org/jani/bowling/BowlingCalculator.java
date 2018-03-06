package org.jani.bowling;

import java.util.List;

class BowlingCalculator {

  int calculate(List<Frame> frames) {
    int totalScore = 0;
    for (int index = 0; index < frames.size(); index++) {
      totalScore += calculateEachFrame(frames, index);
    }
    return totalScore;
  }

  private int calculateEachFrame(List<Frame> frames, int index) {
    Frame frame = frames.get(index);
    if (frame.isBonus()) {
      return 0;
    }
    if (frame.isSpare()) {
      Frame nextFrame = frames.get(index + 1);
      return frame.calculateScore() + nextFrame.getFirstScore();
    }
    if (frame.isStrike()) {
      Frame nextFrame = frames.get(index + 1);
      return frame.calculateScore() + nextFrame.calculateScore();
    }
    return frame.calculateScore();
  }

}

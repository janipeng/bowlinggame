package org.jani.bowling;

import java.util.ArrayList;
import java.util.List;

class BowlingGame {

  private static final String EMPTY = "";

  int calculateScore(String input) {
    String[] records = input.split(EMPTY);
    return calculateTotalScore(buildFrames(records));
  }

  private List<Frame> buildFrames(String[] records) {
    List<Frame> frames = new ArrayList<>();
    int index = 0;
    for (; index < records.length - 1;) {
      frames.add(new Frame(records[index++], records[index++]));
    }
    if (records.length > index) {
      Frame frame = new Frame(records[index], "0");
      frame.setBonus(true);
      frames.add(frame);
    }
    return frames;
  }

  private int calculateTotalScore(List<Frame> frames) {
    int totalScore = 0;
    for (int index = 0; index < frames.size(); index++) {
      totalScore += calculateScoreByFrame(frames, index);
    }
    return totalScore;
  }

  private int calculateScoreByFrame(List<Frame> frames, int index) {
    Frame frame = frames.get(index);
    if (frame.isBonus()) {
      return 0;
    }
    if (frame.isSpare()) {
      Frame nextFrame = frames.get(index + 1);
      return frame.calculateScore() + nextFrame.getFirstScore();
    }
    return frame.calculateScore();
  }

}

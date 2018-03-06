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
    for (int index = 0; index < records.length;) {
      frames.add(new Frame(records[index++], records[index++]));
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
    if (frame.isSpare()) {
      Frame nextFrame = frames.get(index + 1);
      return frame.calculateScore() + nextFrame.getFirstScore();
    }
    return frame.calculateScore();
  }

}

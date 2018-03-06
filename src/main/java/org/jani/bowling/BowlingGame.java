package org.jani.bowling;

import java.util.ArrayList;
import java.util.List;

import static org.jani.bowling.BowlingConstant.STRIKE_SIGNAL;

class BowlingGame {

  private static final String EMPTY = "";
  private static final String ZERO = "0";

  int calculateScore(String input) {
    String[] records = input.split(EMPTY);
    return calculateTotalScore(buildFrames(records));
  }

  private List<Frame> buildFrames(String[] records) {
    List<Frame> frames = new ArrayList<>();
    int index = 0;
    for (; index < records.length - 1;) {
      String record = records[index++];
      if (STRIKE_SIGNAL.equals(record)) {
        frames.add(createFrame(record, ZERO, false));
      } else {
        frames.add(createFrame(record, records[index++], false));
      }
    }
    if (hasBonus(index, records.length)) {
      frames.add(createFrame(records[index], ZERO, true));
    }
    return frames;
  }

  private boolean hasBonus(int index, int length) {
    return length > index;
  }

  private Frame createFrame(String first, String second, boolean bonus) {
    Frame frame = new Frame(first, second);
    frame.setBonus(bonus);
    return frame;
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
    if (frame.isStrike()) {
      Frame nextFrame = frames.get(index + 1);
      return frame.calculateScore() + nextFrame.getFirstScore() + nextFrame.getSecondScore();
    }
    return frame.calculateScore();
  }

}

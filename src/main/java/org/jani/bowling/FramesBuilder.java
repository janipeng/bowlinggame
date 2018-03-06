package org.jani.bowling;

import java.util.ArrayList;
import java.util.List;

import static org.jani.bowling.BowlingConstant.STRIKE_SIGNAL;

class FramesBuilder {

  private static final String EMPTY = "";

  List<Frame> build(String[] records) {
    List<Frame> frames = new ArrayList<>();
    int index = 0;
    for (; index < records.length - 1; index++) {
      if (frames.size() == 10) {
        break;
      }
      frames.add(buildFrame(records, index));
      if (!isStrike(records[index])) {
        index++;
      }
    }
    if (hasBonus(index, records.length)) {
      frames.add(createBonusFrame(records, index));
    }
    return frames;
  }

  private Frame createBonusFrame(String[] records, int index) {
    String firstRecord = records[index++];
    String secondRecord = EMPTY;
    if (records.length > index) {
      secondRecord = records[index];
    }
    return createFrame(firstRecord, secondRecord, true);
  }

  private Frame buildFrame(String[] records, int index) {
    if (isStrike(records[index])) {
      return createFrame(records[index], EMPTY, false);
    }
    return createFrame(records[index], records[index + 1], false);
  }

  private boolean isStrike(String record) {
    return STRIKE_SIGNAL.equals(record);
  }

  private boolean hasBonus(int index, int length) {
    return length > index;
  }

  private Frame createFrame(String first, String second, boolean bonus) {
    Frame frame = new Frame(first, second);
    frame.setBonus(bonus);
    return frame;
  }

}

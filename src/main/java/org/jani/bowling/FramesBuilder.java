package org.jani.bowling;

import java.util.ArrayList;
import java.util.List;

import static org.jani.bowling.BowlingConstant.STRIKE_SIGNAL;

class FramesBuilder {

  private static final String EMPTY = "";

  List<Frame> build(String input) {
    String[] records = input.split(EMPTY);
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
    Frame frame = new Frame(firstRecord, secondRecord);
    frame.setBonus(true);
    return frame;
  }

  private Frame buildFrame(String[] records, int index) {
    Frame frame = new Frame();
    frame.setFirst(records[index]);
    frame.setBonus(false);
    if (!isStrike(records[index])) {
      frame.setSecond(records[index + 1]);
    } else {
      frame.setUpComingRecords(records[index + 1] + records[index + 2]);
    }
    if (frame.isSpare()) {
      frame.setUpComingRecords(records[index + 2]);
    }
    return frame;
  }


  private boolean isStrike(String record) {
    return STRIKE_SIGNAL.equals(record);
  }

  private boolean hasBonus(int index, int length) {
    return length > index;
  }

}

package org.jani.bowling;

import java.util.ArrayList;
import java.util.List;

import static org.jani.bowling.BowlingConstant.STRIKE_SIGNAL;

class FramesBuilder {

  private static final String ZERO = "0";
  private static final String EMPTY = "";

  List<Frame> build(String[] records) {
    List<Frame> frames = new ArrayList<>();
    int index = 0;
    for (; index < records.length - 1;) {
      String record = records[index++];
      Frame frame;
      if (isStrike(record)) {
        frame = createFrame(record, EMPTY, false);
      } else {
        frame = createFrame(record, records[index++], false);
      }
      frames.add(frame);
    }
    if (hasBonus(index, records.length)) {
      frames.add(createFrame(records[index], EMPTY, true));
    }
    return frames;
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

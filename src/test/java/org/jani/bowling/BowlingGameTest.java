package org.jani.bowling;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BowlingGameTest {

  @Test
  public void noSpareAndNoStrike() throws Exception {
    BowlingGame bowlingGame = new BowlingGame();

    int score = bowlingGame.calculateScore("12345123451234512345");

    assertThat(score, is(60));
  }

}

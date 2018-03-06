package org.jani.bowling;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BowlingGameTest {

  private BowlingGame bowlingGame;

  @Before
  public void setUp() throws Exception {
    bowlingGame = new BowlingGame();
  }

  @Test
  public void noSpareAndNoStrike() throws Exception {
    int score = bowlingGame.getScore("12345123451234512345");

    assertThat(score, is(60));
  }

  @Test
  public void oneSpareInFirstFrame() throws Exception {
    int score = bowlingGame.getScore("5/345123451234512345");

    assertThat(score, is(70));
  }

  @Test
  public void oneSpareInLastFrame() throws Exception {
    int score = bowlingGame.getScore("1234512345123451235/5");

    assertThat(score, is(66));
  }

  @Test
  public void oneStrikeInFirstFrame() throws Exception {
    int score = bowlingGame.getScore("X345123451234512345");

    assertThat(score, is(74));
  }
}

package com.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

  private static Game game;

  @BeforeAll
  public static void setUp() {
    game = new Game();
  }

  @Test
  public void
      should_be_return_black_win_when_given_pokers_Black_3H_4H_5H_6H_7H_White_3H_3D_3S_5C_3D() {
    // given
    String white = "3H 3D 3S 5C 3D";
    String black = "3H 4H 5H 6H 7H";
    // when
    String result = game.run(black, white);
    // then
    assertEquals("Black win. - with Straight flush", result);
  }

  @Test
  public void
      should_be_return_white_wins_when_given_pokers_black_3H_4H_5H_6H_7H_white_4S_5S_6S_7S_8S() {
    // given
    String white = "3H 4H 5H 6H 7H";
    String black = "4S 5S 6S 7S 8S";
    // when
    String result = game.run(black, white);
    // then
    assertEquals("Black win. - with high card 8", result);
  }

  @Test
  public void
      should_be_return_black_win_when_given_pokers_black_AS_2S_3S_4S_5S_white_3H_3D_3S_5C_3D() {
    // given
    String white = "3H 3D 3S 5C 3D";
    String black = "AS 2S 3S 4S 5S";
    // when
    String result = game.run(black, white);
    // then
    assertEquals("Black win. - with Straight flush", result);
  }

  @Test
  public void
      should_be_return_white_win_when_given_pokers_black_AS_2S_3S_4S_5S_white_2H_3H_4H_5H_6H() {
    // given
    String white = "2H 3H 4H 5H 6H";
    String black = "AS 2S 3S 4S 5S";
    // when
    String result = game.run(black, white);
    // then
    assertEquals("White win. - with high card 6", result);
  }

  @Test
  public void should_be_return_tie_when_given_pokers_black_3H_4H_5H_6H_7H_white_3S_4S_5S_6S_7S() {
    // given
    String white = "3S 4S 5S 6S 7S";
    String black = "3H 4H 5H 6H 7H";
    // when
    String result = game.run(black, white);
    // then
    assertEquals("Tie", result);
  }

  @Test
  public void
      should_be_return_white_win_when_given_pokers_black_3H_3D_5S_5C_3D_white_3H_3D_3S_5C_3D() {
    // given
    String white = "3H 3D 3S 5C 3D";
    String black = "3H 3D 5S 5C 3D";
    // when
    String result = game.run(black, white);
    // then
    assertEquals("White win. - with Four of a kind", result);
  }

  @Test
  public void
      should_be_return_white_win_when_given_pokers_black_3H_3D_3S_5C_3D_white_4H_4D_4S_5D_4C() {
    // given
    String white = "4H 4D 4S 5D 4C";
    String black = "3H 3D 3S 5C 3D";
    // when
    String result = game.run(black, white);
    // then
    assertEquals("White win. - with high card 4", result);
  }

  @Test
  public void
      should_be_return_white_win_when_given_pokers_black_3H_3D_5S_5C_3D_white_4H_4D_6S_6C_7D() {
    // given
    String white = "3H 3D 5S 5C 3D";
    String black = "4H 4D 6S 6C 7D";
    // when
    String result = game.run(black, white);
    // then
    assertEquals("White win. - with Full House", result);
  }

  @Test
  public void
      should_be_return_white_win_when_given_pokers_black_3H_3D_5S_5C_3D_white_4H_4D_6S_6C_4D() {
    // given
    String white = "3H 3D 5S 5C 3D";
    String black = "4H 4D 6S 6C 4D";
    // when
    String result = game.run(black, white);
    // then
    assertEquals("Black win. - with high card 4", result);
  }

  @Test
  public void
      should_return_white_win_when_given_pokers_black_3H_4D_5S_6C_7D_white_2H_3H_5H_9H_KH() {
    // given
    String black = "3H 4D 5S 6C 7D";
    String white = "2H 3H 5H 9H KH";
    // when
    String result = game.run(black, white);
    // then
    assertEquals("White win. - with Flush", result);
  }

  @Test
  public void
      should_return_white_win_when_given_pokers_black_3S_8S_2S_6S_7S_white_2H_3H_5H_9H_KH() {
    // given
    String black = "3S 8S 2S 6S 7S";
    String white = "2H 3H 5H 9H KH";
    // when
    String result = game.run(black, white);
    // then
    assertEquals("White win. - with high card K", result);
  }

  @Test
  public void
      should_return_black_win_when_given_pokers_black_3S_8S_2S_6S_7S_white_2H_3H_5H_9H_KH() {
    // given
    String black = "3S 8S 2S 6S AS";
    String white = "2H 3H 5H 9H KH";
    // when
    String result = game.run(black, white);
    // then
    assertEquals("Black win. - with high card A", result);
  }

  @Test
  public void should_return_Tie_when_given_pokers_black_2D_3D_5D_9D_white_2H_3H_5H_9H_KH() {
    // given
    String black = "2D 3D 5D 9D KD";
    String white = "2H 3H 5H 9H KH";
    // when
    String result = game.run(black, white);
    // then
    assertEquals("Tie", result);
  }

  @Test
  public void
      should_return_Black_win_when_given_pokers_black_3H_4D_5S_6C_7D_white_3H_3D_5S_9C_3D() {
    // given
    String black = "3H 4D 5S 6C 7D";
    String white = "3H 3D 5S 9C 3D";
    // when
    String result = game.run(black, white);
    // then
    assertEquals("Black win. - with Straight", result);
  }

  @Test
  public void
  should_return_Black_win_when_given_pokers_black_AH_2D_3S_4C_5D_white_3H_3D_5S_9C_3D() {
    // given
    String black = "1H 2D 3S 4C 5D";
    String white = "3H 3D 5S 9C 3D";
    // when
    String result = game.run(black, white);
    // then
    assertEquals("Black win. - with Straight", result);
  }

  @Test
  public void
  should_return_white_win_when_run_given_pokers_black_3H_4D_5S_6C_7D_white_4H_5D_6S_7C_8D() {
    // given
    String black = "3H 4D 5S 6C 7D";
    String white = "4H 5D 6S 7C 8D";
    // when
    String result = game.run(black, white);
    // then
    assertEquals("White win. - with high card 8", result);
  }

  @Test
  public void
  should_return_Tie_when_run_given_pokers_black_3H_4D_5S_6C_7D_white_3H_4D_5S_6C_7S() {
    // given
    String black = "3H 4D 5S 6C 7D";
    String white = "3S 4S 5C 6S 7S";
    // when
    String result = game.run(black, white);
    // then
    assertEquals("Tie", result);
  }

  @Test
  public void
  should_return_Tie_when_run_given_pokers_black_3H_3D_5S_9C_5D_white_3H_3D_5S_9C_3D() {
    // given
    String black = "3H 3D 5S 9C 5D";
    String white = "3H 3D 5S 9C 3D";
    // when
    String result = game.run(black, white);
    // then
    assertEquals("White win. - with Three of a kind", result);
  }
}

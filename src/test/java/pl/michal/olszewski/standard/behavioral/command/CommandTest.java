package pl.michal.olszewski.standard.behavioral.command;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CommandTest {

  private Light lamp = new Light();

  @Test
  void shouldSwitchOnLight() {
    //given
    final Command switchUp = new LightOnCommand(lamp);
    //when
    switchUp.execute();
    //then
    assertThat(lamp.getOn()).isTrue();
  }

  @Test
  void shouldCancelSwitchOnLight() {
    //given
    final Command switchUp = new LightOnCommand(lamp);

    //when
    switchUp.execute();
    switchUp.cancel();
    //then
    assertThat(lamp.getOn()).isFalse();
  }

  @Test
  void shouldSwitchOffLight() {
    //given
    final Command switchOff = new LightOffCommand(lamp);

    //when
    switchOff.execute();
    //then
    assertThat(lamp.getOn()).isFalse();
  }

  @Test
  void shouldCancelSwitchOffLight() {
    //given
    final Command switchUp = new LightOffCommand(lamp);

    //when
    switchUp.execute();
    switchUp.cancel();
    //then
    assertThat(lamp.getOn()).isTrue();
  }
}
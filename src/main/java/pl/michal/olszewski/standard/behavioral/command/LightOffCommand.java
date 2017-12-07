package pl.michal.olszewski.standard.behavioral.command;

/**
 * Concrete command
 *
 * klasa dostarczająca implementacji interfejsu polecenia, koncentrująca się na obsłudze pojedynczego zadania. Dla każdego rodzaju obsługiwanego polecenia tworzymy oddzielną klasę.
 */
public class LightOffCommand implements Command {

  private final Light light;

  public LightOffCommand(Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    light.switchOff();
  }

  @Override
  public void cancel() {
    light.switchOn();
  }
}

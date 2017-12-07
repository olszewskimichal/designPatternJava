package pl.michal.olszewski.standard.behavioral.command;

/**
 * Concrete command
 */
public class LightOnCommand implements Command {

  private final Light light;

  public LightOnCommand(Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    light.switchOn();
  }

  @Override
  public void cancel() {
    light.switchOff();
  }
}

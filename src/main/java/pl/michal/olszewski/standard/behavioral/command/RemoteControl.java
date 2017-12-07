package pl.michal.olszewski.standard.behavioral.command;

public class RemoteControl {

  private Command command;

  public void setCommand(Command command) {
    this.command = command;
  }

  public void pressButton() {
    command.execute();
  }

  public void pressCancel() {
    command.cancel();
  }


}
package pl.michal.olszewski.standard.behavioral.nullObject;

public class Programmer extends AbstractEmployee {

  public Programmer(String name) {
    this.name = name;
  }

  @Override
  public boolean isNull() {
    return false;
  }

  @Override
  public String getName() {
    return name;
  }
}

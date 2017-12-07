package pl.michal.olszewski.standard.behavioral.nullObject;

public class NullEmployee extends AbstractEmployee {

  @Override
  public boolean isNull() {
    return true;
  }

  @Override
  public String getName() {
    return null;
  }
}

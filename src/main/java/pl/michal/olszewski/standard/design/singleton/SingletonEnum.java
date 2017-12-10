package pl.michal.olszewski.standard.design.singleton;

public enum SingletonEnum {
  INSTANCE();

  SingletonEnum() {

  }

  public SingletonEnum getInstance() {
    return INSTANCE;
  }
}

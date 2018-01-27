package pl.michal.olszewski.standard.creational.singleton;

public enum SingletonEnum {
  INSTANCE();

  SingletonEnum() {

  }

  public SingletonEnum getInstance() {
    return INSTANCE;
  }
}

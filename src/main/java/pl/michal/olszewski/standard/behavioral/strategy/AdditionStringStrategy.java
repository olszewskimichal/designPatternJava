package pl.michal.olszewski.standard.behavioral.strategy;

public class AdditionStringStrategy implements Strategy<String> {

  @Override
  public String calculate(String firstValue, String secondValue) {
    return firstValue + (secondValue);
  }
}

package pl.michal.olszewski.standard.behavioral.strategy;

/**
 *  Klient — użytkownik rodziny algorytmów posiadający referencję do obiektu Strategia.
 */
public class Context<T> {

  private Strategy<T> strategy;

  public Context(Strategy<T> strategy) {
    this.strategy = strategy;
  }

  public T calculate(T firstValue, T secondValue) {
    return this.strategy.calculate(firstValue, secondValue);
  }

}

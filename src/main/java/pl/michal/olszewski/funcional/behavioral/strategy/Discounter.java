package pl.michal.olszewski.funcional.behavioral.strategy;

import static pl.michal.olszewski.funcional.behavioral.strategy.Discounter.christmas;
import static pl.michal.olszewski.funcional.behavioral.strategy.Discounter.easter;
import static pl.michal.olszewski.funcional.behavioral.strategy.Discounter.newYear;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;


public interface Discounter extends UnaryOperator<BigDecimal> {

  default Discounter combine(Discounter after) {
    return value -> after.apply(this.apply(value));
  }

  static Discounter christmas() {
    return (amount) -> amount.multiply(BigDecimal.valueOf(0.9));
  }

  static Discounter newYear() {
    return (amount) -> amount.multiply(BigDecimal.valueOf(0.8));
  }

  static Discounter easter() {
    return (amount) -> amount.multiply(BigDecimal.valueOf(0.5));
  }

}

class Main {

  public static void main(String[] args) {
    System.out.println(christmas().apply(BigDecimal.TEN));
    System.out.println(newYear().apply(BigDecimal.TEN));
    System.out.println(easter().apply(BigDecimal.TEN));

    List<Discounter> discounters = Arrays.asList(christmas(), newYear(), easter());
    BigDecimal amount = BigDecimal.valueOf(100);

    final Discounter combinedDiscounter = discounters
        .stream()
        .reduce(v -> v, Discounter::combine);

    System.out.println(combinedDiscounter.apply(amount));
  }
}
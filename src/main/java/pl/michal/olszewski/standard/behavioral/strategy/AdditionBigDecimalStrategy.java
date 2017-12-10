package pl.michal.olszewski.standard.behavioral.strategy;

import java.math.BigDecimal;

/**
 *  Konkretna strategia — implementuje określony algorytm zgodnie ze zdefiniowanym interfejsem.
 */
public class AdditionBigDecimalStrategy implements Strategy<BigDecimal> {

  @Override
  public BigDecimal calculate(BigDecimal firstValue, BigDecimal secondValue) {
    return firstValue.add(secondValue);
  }
}

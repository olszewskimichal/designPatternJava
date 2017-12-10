package pl.michal.olszewski.standard.behavioral.strategy;

import java.math.BigDecimal;

public class SubtractionBigDecimalStrategy implements Strategy<BigDecimal> {

  @Override
  public BigDecimal calculate(BigDecimal firstValue, BigDecimal secondValue) {
    return firstValue.subtract(secondValue);
  }
}

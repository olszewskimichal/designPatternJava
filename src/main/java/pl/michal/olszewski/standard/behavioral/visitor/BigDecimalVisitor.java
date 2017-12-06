package pl.michal.olszewski.standard.behavioral.visitor;

import java.math.BigDecimal;

public class BigDecimalVisitor implements Visitor<BigDecimal> {

  @Override
  public BigDecimal visit(Foo foo) {
    return BigDecimal.TEN;
  }

  @Override
  public BigDecimal visit(Bar bar) {
    return BigDecimal.ONE;
  }

  @Override
  public BigDecimal visit(Baz baz) {
    return BigDecimal.ZERO;
  }
}

package pl.michal.olszewski.standard.behavioral.chainResponsibility;

import java.math.BigDecimal;

public class Dollar50Dispenser implements DispenseChain {

  static BigDecimal value = BigDecimal.valueOf(50);

  private DispenseChain chain;

  @Override
  public BigDecimal getDispenseValue() {
    return value;
  }

  @Override
  public DispenseChain getNext() {
    return chain;
  }

  @Override
  public void setNext(DispenseChain next) {
    this.chain = next;
  }

}

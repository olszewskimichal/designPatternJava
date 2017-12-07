package pl.michal.olszewski.standard.design.chainResponsibility;

import java.math.BigDecimal;

public class Dollar50Dispenser implements DispenseChain {

  static BigDecimal value = BigDecimal.valueOf(50);

  private DispenseChain chain;

  @Override
  public BigDecimal getDispenseValue() {
    return value;
  }

  @Override
  public void setNext(DispenseChain next) {
    this.chain = next;
  }

  @Override
  public DispenseChain getNext() {
    return chain;
  }

}

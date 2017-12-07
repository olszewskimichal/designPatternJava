package pl.michal.olszewski.standard.design.chainResponsibility;

import static java.lang.System.out;

import java.math.BigDecimal;

public interface DispenseChain {

  BigDecimal getDispenseValue();

  void setNext(DispenseChain next);

  DispenseChain getNext();

  default Integer dispense(BigDecimal currency) {
    if (currency.compareTo(getDispenseValue()) >= 0) {
      currency = currency.subtract(getDispenseValue());
      out.println("Wydałem " + getDispenseValue());
      if (currency.compareTo(BigDecimal.ZERO) != 0) {
        return this.dispense(currency) + 1;
      }
      return 1;
    } else {
      return this.getNext().dispense(currency);
    }
  }
}

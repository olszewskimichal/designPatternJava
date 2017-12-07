package pl.michal.olszewski.standard.design.decorator;

import java.math.BigDecimal;

class Pizza extends Product {

  @Override
  BigDecimal getPrice() {
    return BigDecimal.TEN;
  }

  @Override
  void getDescription() {
    System.out.println("Pizza");
  }
}

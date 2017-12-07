package pl.michal.olszewski.standard.design.decorator;

import java.math.BigDecimal;

class OlivesDecorator extends Decorator {

  OlivesDecorator(Product product) {
    super(product);
  }

  @Override
  BigDecimal getPrice() {
    return product.getPrice().add(BigDecimal.valueOf(2));
  }

  @Override
  void getDescription() {
    product.getDescription();
    System.out.println("Z dodatkowymi oliwkami");
  }
}

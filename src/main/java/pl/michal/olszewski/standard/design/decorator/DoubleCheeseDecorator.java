package pl.michal.olszewski.standard.design.decorator;

import java.math.BigDecimal;

class DoubleCheeseDecorator extends Decorator {

  DoubleCheeseDecorator(Product product) {
    super(product);
  }

  @Override
  BigDecimal getPrice() {
    return product.getPrice().add(BigDecimal.valueOf(5));
  }

  @Override
  void getDescription() {
    product.getDescription();
    System.out.println("Z dodatkowym serem");
  }
}

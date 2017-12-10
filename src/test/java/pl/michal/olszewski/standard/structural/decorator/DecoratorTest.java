package pl.michal.olszewski.standard.structural.decorator;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class DecoratorTest {

  @Test
  void shouldRegularPizzaCost10() {
    Pizza pizza = new Pizza();
    assertThat(pizza.getPrice()).isEqualTo(BigDecimal.TEN);
    pizza.getDescription();
  }

  @Test
  void shouldPizzaWithExtraCheeseCost15() {
    DoubleCheeseDecorator pizza = new DoubleCheeseDecorator(new Pizza());
    assertThat(pizza.getPrice()).isEqualTo(BigDecimal.valueOf(15));
    pizza.getDescription();
  }

  @Test
  void shouldPizzaWithExtraCheeseAndOlivesCost17() {
    OlivesDecorator pizza = new OlivesDecorator(new DoubleCheeseDecorator(new Pizza()));
    assertThat(pizza.getPrice()).isEqualTo(BigDecimal.valueOf(17));
    pizza.getDescription();
  }
}
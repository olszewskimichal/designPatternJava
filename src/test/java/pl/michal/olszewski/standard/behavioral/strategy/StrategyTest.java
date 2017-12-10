package pl.michal.olszewski.standard.behavioral.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class StrategyTest {

  @Test
  void shouldAdd2BigDecimalsWithAdditionStrategy() {
    Context<BigDecimal> bigDecimalContext = new Context<>(new AdditionBigDecimalStrategy());
    BigDecimal calculate = bigDecimalContext.calculate(BigDecimal.TEN, BigDecimal.ONE);
    assertThat(calculate).isEqualTo(BigDecimal.valueOf(11));
  }

  @Test
  void shouldSubtract2BigDecimalsSubtractionStrategy() {
    Context<BigDecimal> bigDecimalContext = new Context<>(new SubtractionBigDecimalStrategy());
    BigDecimal calculate = bigDecimalContext.calculate(BigDecimal.TEN, BigDecimal.ONE);
    assertThat(calculate).isEqualTo(BigDecimal.valueOf(9));
  }

  @Test
  void shouldConcatenate2StringWithAdditionStrategy() {
    Context<String> bigDecimalContext = new Context<>(new AdditionStringStrategy());
    String calculate = bigDecimalContext.calculate(BigDecimal.TEN.toString(), BigDecimal.ONE.toString());
    assertThat(calculate).isEqualTo(BigDecimal.valueOf(101).toString());
  }
}
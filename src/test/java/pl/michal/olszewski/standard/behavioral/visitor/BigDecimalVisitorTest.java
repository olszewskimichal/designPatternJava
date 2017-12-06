package pl.michal.olszewski.standard.behavioral.visitor;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.TEN;
import static java.math.BigDecimal.ZERO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BigDecimalVisitorTest {

  @BeforeEach
  void setUp() {
    visitor = new BigDecimalVisitor();
  }

  private Visitor visitor = null;

  @Test
  void fooTest() {
    Visitable visitable = new Foo();
    assertThat(visitable.accept(visitor)).isEqualTo(TEN);
  }

  @Test
  void barTest() {
    Visitable visitable = new Bar();
    assertThat(visitable.accept(visitor)).isEqualTo(BigDecimal.ONE);
  }

  @Test
  void bazTest() {
    Visitable visitable = new Baz();
    assertThat(visitable.accept(visitor)).isEqualTo(BigDecimal.ZERO);
  }

  @Test
  void allTest() {
    List<Visitable> list = Arrays.asList(new Foo(), new Bar(), new Baz());
    assertThat(list.stream().map(v -> v.accept(visitor))).contains(TEN,ONE,ZERO);
  }
}
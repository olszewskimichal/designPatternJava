package pl.michal.olszewski.standard.behavioral.visitor;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.TEN;
import static java.math.BigDecimal.ZERO;
import static org.assertj.core.api.Assertions.assertThat;
import static pl.michal.olszewski.funcional.behavioral.visitor.VisitorLambda.bigDecimalVisitor;
import static pl.michal.olszewski.funcional.behavioral.visitor.VisitorLambda.stringVisitor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class VisitorTest {

  @Nested
  class BigDecimalVisitorTest {

    private Visitor visitor = null;

    @BeforeEach
    void setUp() {
      visitor = new BigDecimalVisitor();
    }

    @Test
    void fooTest() {
      Visitable visitable = new Foo();
      assertThat(visitable.accept(visitor)).isEqualTo(TEN);
    }

    @Test
    void fooLambdaTest() {
      Visitable visitable = new Foo();
      assertThat(bigDecimalVisitor.apply(visitable)).isEqualTo(TEN);
    }

    @Test
    void barTest() {
      Visitable visitable = new Bar();
      assertThat(visitable.accept(visitor)).isEqualTo(BigDecimal.ONE);
    }

    @Test
    void barLambdaTest() {
      Visitable visitable = new Bar();
      assertThat(bigDecimalVisitor.apply(visitable)).isEqualTo(ONE);
    }

    @Test
    void bazTest() {
      Visitable visitable = new Baz();
      assertThat(visitable.accept(visitor)).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    void bazLambdaTest() {
      Visitable visitable = new Baz();
      assertThat(bigDecimalVisitor.apply(visitable)).isEqualTo(ZERO);
    }

    @Test
    void allTest() {
      List<Visitable> list = Arrays.asList(new Foo(), new Bar(), new Baz());
      assertThat(list.stream().map(v -> v.accept(visitor))).contains(TEN, ONE, ZERO);
    }
  }

  @Nested
  class StringVisitorTest {

    private Visitor visitor = null;

    @BeforeEach
    void setUp() {
      visitor = new StringVisitor();
    }

    @Test
    void fooTest() {
      Visitable visitable = new Foo();
      assertThat(visitable.accept(visitor)).isEqualTo("FOO");
    }

    @Test
    void barTest() {
      Visitable visitable = new Bar();
      assertThat(visitable.accept(visitor)).isEqualTo("BAR");
    }

    @Test
    void bazTest() {
      Visitable visitable = new Baz();
      assertThat(visitable.accept(visitor)).isEqualTo("BAZ");
    }


    @Test
    void fooLambdaTest() {
      Visitable visitable = new Foo();
      assertThat(stringVisitor.apply(visitable)).isEqualTo("FOO");
    }

    @Test
    void barLambdaTest() {
      Visitable visitable = new Bar();
      assertThat(stringVisitor.apply(visitable)).isEqualTo("BAR");
    }

    @Test
    void bazLambdaTest() {
      Visitable visitable = new Baz();
      assertThat(stringVisitor.apply(visitable)).isEqualTo("BAZ");
    }

    @Test
    void allTest() {
      List<Visitable> list = Arrays.asList(new Foo(), new Bar(), new Baz());
      assertThat(list.stream().map(v -> v.accept(visitor))).contains("FOO", "BAR", "BAZ");
    }
  }
}

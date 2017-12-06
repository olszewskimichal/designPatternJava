package pl.michal.olszewski.standard.behavioral.visitor;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringVisitorTest {

  @BeforeEach
  void setUp() {
    visitor = new StringVisitor();
  }

  private Visitor visitor = null;

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
  void allTest() {
    List<Visitable> list = Arrays.asList(new Foo(), new Bar(), new Baz());
    assertThat(list.stream().map(v -> v.accept(visitor))).contains("FOO", "BAR", "BAZ");
  }
}
package pl.michal.olszewski.standard.typeOf;

import static com.nurkiewicz.typeof.TypeOf.whenTypeOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;

import java.time.LocalDate;
import java.util.Date;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class IsThenReturnTest {

  @Test
  void testReturnFirstMatchingClause() {
    //when
    final int result = whenTypeOf(42)
        .is(Integer.class).thenReturn(i -> i + 1).
            get();

    //then
    assertThat(result).isEqualTo(43);
  }

  @Test
  void testReturnFirstMatchingClauseWithFixedValue() {
    //when
    final int result = whenTypeOf(42)
        .is(Integer.class).thenReturn(43).
            get();

    //then
    assertThat(result).isEqualTo(43);
  }

  @Test
  void testReturnFirstMatchingClauseOfSuperClass() {
    //when
    final int result = whenTypeOf(42).
        is(Number.class).thenReturn(n -> n.intValue() + 1).
        is(Integer.class).thenReturn(i -> i - 1).
        is(Object.class).thenReturn(obj -> -1).
        get();

    //then
    assertThat(result).isEqualTo(42 + 1);
  }

  @Test
  void testReturnSubsequent() {
    //when
    final int result = whenTypeOf(42).
        is(String.class).thenReturn(String::length).
        is(Date.class).thenReturn(d -> (int) d.getTime()).
        is(Integer.class).thenReturn(i -> i - 1).
        is(Object.class).thenReturn(obj -> -1).
        get();

    //then
    assertThat(result).isEqualTo(42 - 1);
  }

  @Test
  void testReturnSubsequentWithFixedValue() {
    //when
    final int result = whenTypeOf(42).
        is(String.class).thenReturn(-1).
        is(Integer.class).thenReturn(17).
        is(Object.class).thenReturn(-1).
        get();

    //then
    assertThat(result).isEqualTo(17);
  }

  @Test
  void testOrElseBlockWithClosure() {
    //when
    final int result = whenTypeOf(42).
        is(String.class).thenReturn(String::length).
        is(Date.class).thenReturn(d -> (int) d.getTime()).
        is(Float.class).thenReturn(Float::intValue).
        orElse(x -> x + 1);

    //then
    assertThat(result).isEqualTo(42 + 1);
  }

  @Test
  void testOrElseBlockWithFixedValue() {
    //when
    final int result = whenTypeOf(42).
        is(String.class).thenReturn(String::length).
        is(Date.class).thenReturn(d -> (int) d.getTime()).
        is(Float.class).thenReturn(Float::intValue).
        orElse(17);

    //then
    assertThat(result).isEqualTo(17);
  }

  @Test
  void testThrowWhenGetCalledButSingleClauseNotMatching() {
    try {
      whenTypeOf(42).
          is(String.class).thenReturn(String::length).
          get();
      failBecauseExceptionWasNotThrown(NoSuchElementException.class);
    } catch (NoSuchElementException e) {
      assertThat(e).hasMessage("42");
    }
  }

  @Test
  void testThrowWhenGetCalledButNeitherClausesWorked() {
    try {
      whenTypeOf(42).
          is(String.class).thenReturn(String::length).
          is(Date.class).thenReturn(d -> (int) d.getTime()).
          is(Float.class).thenReturn(Float::intValue).
          get();
      failBecauseExceptionWasNotThrown(NoSuchElementException.class);
    } catch (NoSuchElementException e) {
      assertThat(e).hasMessage("42");
    }
  }

  @Test
  void testThrowWhenGetCalledButNeitherClausesWorkedWithFixedValue() {
    try {
      whenTypeOf(42).
          is(String.class).thenReturn(-1).
          is(Date.class).thenReturn(-1).
          get();
      failBecauseExceptionWasNotThrown(NoSuchElementException.class);
    } catch (NoSuchElementException e) {
      assertThat(e).hasMessage("42");
    }
  }

  @Test
  void shouldNotFailWhenNullPassedAndClosureOrElseResult() {
    //when
    final int result = whenTypeOf(null).
        is(String.class).thenReturn(String::length).
        is(Date.class).thenReturn(d -> (int) d.getTime()).
        is(Float.class).thenReturn(Float::intValue).
        orElse(x -> x != null ? -1 : 1);

    //then
    assertThat(result).isEqualTo(1);
  }

  @Test
  void shouldNotFailWhenNullPassed() {
    //when
    final int result = whenTypeOf(null).
        is(String.class).thenReturn(String::length).
        is(Date.class).thenReturn(d -> (int) d.getTime()).
        is(Float.class).thenReturn(Float::intValue).
        orElse(17);

    //then
    assertThat(result).isEqualTo(17);
  }

  @Test
  void shouldNotReturnOrElseValueWhenSuccessful() {
    // when
    final Integer result = whenTypeOf("100").
        is(String.class).thenReturn(Integer::valueOf).
        is(Date.class).thenReturn(d -> (int) d.getTime()).
        is(Float.class).thenReturn(Float::intValue).
        orElse(x -> 12345);

    assertThat(result).isEqualTo(100);
  }

  @Test
  void shouldNotReturnOrElseValueWhenSuccessfulDate() {
    // when
    final LocalDate result = whenTypeOf("100").
        is(String.class).thenReturn(LocalDate.now()).
        is(Date.class).thenReturn(LocalDate.now().plusDays(1)).
        is(Float.class).thenReturn(LocalDate.now().minusDays(1)).
        orElse(x -> LocalDate.MIN);

    assertThat(result).isEqualTo(LocalDate.now());
  }
}
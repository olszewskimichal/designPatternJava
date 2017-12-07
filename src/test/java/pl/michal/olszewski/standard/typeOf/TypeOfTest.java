package pl.michal.olszewski.standard.typeOf;

import static com.nurkiewicz.typeof.TypeOf.whenTypeOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

import java.time.LocalDate;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import pl.michal.olszewski.extensions.MockitoExtension;

public class TypeOfTest {
  @Nested
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

  @Nested
  @ExtendWith(MockitoExtension.class)
  class IsThenTest {

    @Mock
    private Consumer<Integer> mock;

    @Test
    void testWithSingleNonMatchingClause() {
      whenTypeOf(42).
          is(String.class)
          .then(s -> mock.accept(1));

      //then
      verifyZeroInteractions(mock);
    }

    @Test
    void testWithSingleMatchingClause() {
      //when
      whenTypeOf(42).
          is(Integer.class)
          .then(x -> mock.accept(2));

      //then
      verify(mock).accept(2);
    }

    @Test
    void testWithSingleMatchOfUpperClass() {
      //given
      whenTypeOf(42).
          is(Number.class)
          .then(x -> mock.accept(2));

      //then
      verify(mock).accept(2);
    }

    @Test
    void testShouldPickFirstMatchingAndNotFallThroughRemaining() {
      //given
      whenTypeOf(42).
          is(Date.class).then(d -> mock.accept(2)).
          is(Number.class).then(x -> mock.accept(3)).
          is(Integer.class).then(x -> mock.accept(4)).
          is(Float.class).then(x -> mock.accept(5)).
          is(Byte.class).then(x -> mock.accept(6));

      //then
      verify(mock).accept(3);
      verifyNoMoreInteractions(mock);
    }

    @Test
    void testLastClauseMatchingOutOfMany() {
      //given
      whenTypeOf(42).
          is(Date.class).then(d -> mock.accept(7)).
          is(Float.class).then(x -> mock.accept(8)).
          is(Byte.class).then(x -> mock.accept(9)).
          is(Integer.class).then(x -> mock.accept(10));

      //then
      verify(mock).accept(10);
      verifyNoMoreInteractions(mock);
    }

    @Test
    void testLastClauseNotMatching() {
      //given
      whenTypeOf(42).
          is(Date.class).then(d -> mock.accept(7)).
          is(Float.class).then(x -> mock.accept(8)).
          is(Byte.class).then(x -> mock.accept(9)).
          is(String.class).then(x -> mock.accept(10));

      //then
      verifyZeroInteractions(mock);
    }

    @Test
    void testShouldCatchObject() {
      //given
      whenTypeOf(42).
          is(Date.class).then(d -> mock.accept(7)).
          is(Float.class).then(x -> mock.accept(8)).
          is(Byte.class).then(x -> mock.accept(9)).
          is(String.class).then(x -> mock.accept(10)).
          is(Object.class).then(x -> mock.accept(11));

      //then
      verify(mock).accept(11);
      verifyNoMoreInteractions(mock);
    }

    @Test
    void testShouldRunOrElseBlock() {
      //given
      whenTypeOf(42).
          is(Date.class).then(d -> mock.accept(7)).
          is(Float.class).then(x -> mock.accept(8)).
          is(Byte.class).then(x -> mock.accept(9)).
          is(String.class).then(x -> mock.accept(10)).
          orElse(mock::accept);

      //then
      verify(mock).accept(42);
      verifyNoMoreInteractions(mock);
    }

    @Test
    void testShouldNotFailWhenNullPassedAndSingleClause() {
      //given
      whenTypeOf(null).
          is(Date.class).then(d -> mock.accept(7)).
          orElse(obj -> mock.accept(2));

      //then
      verify(mock).accept(2);
      verifyNoMoreInteractions(mock);
    }

    @Test
    void shouldNotFailWhenNullPassedAndMultipleClauses() {
      //given
      whenTypeOf(null).
          is(Date.class).then(d -> mock.accept(7)).
          is(Float.class).then(x -> mock.accept(8)).
          is(Byte.class).then(x -> mock.accept(9)).
          is(String.class).then(x -> mock.accept(10)).
          orElse(obj -> mock.accept(2));

      //then
      verify(mock).accept(2);
      verifyNoMoreInteractions(mock);
    }

  }

}

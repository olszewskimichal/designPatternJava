package pl.michal.olszewski.standard.typeOf;

import static com.nurkiewicz.typeof.TypeOf.whenTypeOf;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

import java.util.Date;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import pl.michal.olszewski.extensions.MockitoExtension;

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

package pl.michal.olszewski.standard.behavioral;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import pl.michal.olszewski.standard.behavioral.interpreter.AndExpression;
import pl.michal.olszewski.standard.behavioral.interpreter.Expression;
import pl.michal.olszewski.standard.behavioral.interpreter.OrExpression;
import pl.michal.olszewski.standard.behavioral.interpreter.TerminalContainsExpression;

class InterpreterTest {

  @Test
  void shouldTerminalExpReturnTrueWhenContainsName() {
    Expression robert = new TerminalContainsExpression("Robert");
    assertThat(robert.interpret("Robert")).isTrue();
  }

  @Test
  void shouldTerminalExpReturnTrueWhenNotContainsName() {
    Expression robert = new TerminalContainsExpression("Robert");
    assertThat(robert.interpret("Bogdan")).isFalse();
  }

  @Test
  void shouldReturnTrueIfIsMarriedWoman() {
    Expression julie = new TerminalContainsExpression("Julie");
    Expression married = new TerminalContainsExpression("Married");
    AndExpression isMarriedWoman = new AndExpression(julie, married);
    assertThat(isMarriedWoman.interpret("Married Julie")).isTrue();
  }

  @Test
  void shouldReturnTrueIfIsMale() {
    Expression robert = new TerminalContainsExpression("Robert");
    Expression john = new TerminalContainsExpression("John");
    OrExpression isMale = new OrExpression(robert, john);
    assertThat(isMale.interpret("John")).isTrue();
    assertThat(isMale.interpret("Julie")).isFalse();
  }

}

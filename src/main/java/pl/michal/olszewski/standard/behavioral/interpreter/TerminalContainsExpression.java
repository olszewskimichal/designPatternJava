package pl.michal.olszewski.standard.behavioral.interpreter;

public class TerminalContainsExpression implements Expression {

  private final String data;

  public TerminalContainsExpression(String data) {
    this.data = data;
  }

  @Override
  public boolean interpret(String context) {
    return context.contains(data);
  }
}

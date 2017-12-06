package pl.michal.olszewski.standard.behavioral.visitor;

public class Baz implements Visitable {

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }
}

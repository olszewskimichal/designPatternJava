package pl.michal.olszewski.standard.behavioral.visitor;

public class Bar implements Visitable {

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }
}

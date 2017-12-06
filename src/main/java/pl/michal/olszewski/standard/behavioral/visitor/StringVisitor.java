package pl.michal.olszewski.standard.behavioral.visitor;

public class StringVisitor implements Visitor<String> {

  @Override
  public String visit(Foo foo) {
    return "FOO";
  }

  @Override
  public String visit(Bar bar) {
    return "BAR";
  }

  @Override
  public String visit(Baz baz) {
    return "BAZ";
  }
}

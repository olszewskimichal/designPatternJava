package pl.michal.olszewski.standard.behavioral.visitor;

public interface Visitor<T> {

  T visit(Foo foo);

  T visit(Bar bar);

  T visit(Baz baz);
}
package pl.michal.olszewski.standard.behavioral.visitor;

public interface Visitable {
  <T> T accept(Visitor<T> visitor);
}
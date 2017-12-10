package pl.michal.olszewski.standard.behavioral.observer;

import java.util.Optional;

public class BinaryObserver extends Observer {

  public BinaryObserver(Subject subject) {
    this.subject = subject;
    this.subject.addObserver(this);
  }

  @Override
  public void update(Integer oldValue) {
    Optional.ofNullable(oldValue).ifPresentOrElse(
        v -> System.out.println("Binary OldValue String: " + Integer.toBinaryString(v).toUpperCase() + " Binary NewValue String: " + Integer.toHexString(subject.getState()).toUpperCase()),
        () -> System.out.println("Binary NewValue String: " + Integer.toBinaryString(subject.getState()).toUpperCase())
    );
  }
}

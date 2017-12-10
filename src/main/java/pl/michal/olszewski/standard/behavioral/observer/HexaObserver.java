package pl.michal.olszewski.standard.behavioral.observer;

import java.util.Optional;

/**
 * Concrete observer
 */
public class HexaObserver extends Observer {

  public HexaObserver(Subject subject) {
    this.subject = subject;
    this.subject.addObserver(this);
  }

  @Override
  public void update(Integer oldValue) {
    Optional.ofNullable(oldValue)
        .ifPresentOrElse(v -> System.out.println("Hex OldValue String: " + Integer.toHexString(v).toUpperCase() + " Hex NewValue String: " + Integer.toHexString(subject.getState()).toUpperCase()),
            () -> System.out.println("Hex NewValue String: " + Integer.toHexString(subject.getState()).toUpperCase())
        );
  }
}
package pl.michal.olszewski.standard.behavioral.observer;

import org.junit.jupiter.api.Test;

class ObserverTest {

  @Test
  void test() {
    Subject subject = new Subject();

    new HexaObserver(subject);
    new BinaryObserver(subject);

    System.out.println("First state change: 15");
    subject.setState(15);

    System.out.println("Second state change: 127");
    subject.setState(127);
  }

}
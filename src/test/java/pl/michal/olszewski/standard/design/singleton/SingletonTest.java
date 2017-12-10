package pl.michal.olszewski.standard.design.singleton;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import pl.michal.olszewski.standard.design.singleton.ClassSingleton;

class SingletonTest {

  @Test
  void shouldGetTheSameInstanceOfClass() {
    ClassSingleton instance = ClassSingleton.getInstance();
    ClassSingleton instance1 = ClassSingleton.getInstance();
    assertSame(instance, instance1);
  }

  @Test
  void shouldGetTheSameInstanceOfEnum() {
    SingletonEnum instance = SingletonEnum.INSTANCE.getInstance();
    SingletonEnum instance1 = SingletonEnum.INSTANCE.getInstance();
    assertSame(instance, instance1);
  }
}
package pl.michal.olszewski.standard.design.singleton;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
/*
Zalety:

Pobieranie instancji klasy jest niewidoczne dla użytkownika. Nie musi on wiedzieć, czy w chwili wywołania metody instancja istnieje czy dopiero jest tworzona.
Tworzenie nowej instancji zachodzi dopiero przy pierwszej próbie użycia.
Klasa zaimplementowana z użyciem wzorca singleton może samodzielnie kontrolować liczbę swoich instancji istniejących w aplikacji.
Wady:

Brak elastyczności, ponieważ już na poziomie kodu, na „sztywno” określana jest liczba instancji klasy.
Utrudnia testowanie i usuwanie błędów w aplikacji. Poważnie utrudnia testowanie aplikacji przez wprowadzenie do niej globalnego stanu


 */
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
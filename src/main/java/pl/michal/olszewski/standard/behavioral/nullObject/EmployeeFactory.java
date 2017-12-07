package pl.michal.olszewski.standard.behavioral.nullObject;

import java.util.Arrays;
import java.util.List;

/**
 * Wzorzec null object
 *
 * gdy chcemy aby nasza metoda nie zwracała obiektu, np. w skutek nie spełnienia jakiegoś warunku, zwrócić tytułowy Null Object zamiast pustej referencji czyli null
 */
public class EmployeeFactory {

  private static final List<AbstractEmployee> names = Arrays.asList(new Programmer("Rob"), new Programmer("Joe"), new Programmer("Julie"));

  public AbstractEmployee getEmployee(String name) {
    return names.stream().filter(v -> v.getName().equals(name)).findFirst()
        .orElse(new NullEmployee());
  }
}

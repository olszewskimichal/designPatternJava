package pl.michal.olszewski.standard.structural.composite;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

/**
 * Klient– operuje na danych zawartych we wzorcu
 */
class CompositeTest {

  @Test
  void shouldReturnAllSalary() {
    Employee employee = new Developer("Aaa", BigDecimal.ONE);
    Employee employee2 = new Developer("Bbb", BigDecimal.TEN);
    Employee manager = new Manager("Ccc", BigDecimal.ZERO);
    manager.addEmployee(employee);
    manager.addEmployee(employee2);
    Employee generalManager = new Manager("Ddd", BigDecimal.valueOf(15));
    generalManager.addEmployee(manager);

    assertAll(
        () -> assertThat(employee.getSalary()).isEqualTo(BigDecimal.ONE),
        () -> assertThat(manager.getSalary()).isEqualTo(BigDecimal.valueOf(11)),
        () -> assertThat(generalManager.getSalary()).isEqualTo(BigDecimal.valueOf(26)),
        () -> assertThrows(IllegalStateException.class, () -> employee.addEmployee(employee2))
    );
  }
}
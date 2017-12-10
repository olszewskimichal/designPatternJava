package pl.michal.olszewski.standard.behavioral.nullObject;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NullObjectTest {

  @Test
  void shouldReturnProgrammerWhenExist() {
    EmployeeFactory employeeFactory = new EmployeeFactory();
    AbstractEmployee rob = employeeFactory.getEmployee("Rob");
    assertThat(rob.isNull()).isFalse();
    assertThat(rob.getName()).isEqualTo("Rob");
  }

  @Test
  void shouldReturnNullObjectWhenEmployeeNotExists() {
    EmployeeFactory employeeFactory = new EmployeeFactory();
    AbstractEmployee employee = employeeFactory.getEmployee("Robin");
    assertThat(employee.isNull()).isTrue();
  }

}
package pl.michal.olszewski.standard.structural.composite;

import java.math.BigDecimal;

/**
 * Component
 *
 * -- declares interface for objects in composition.
 * -- implements deafault behaviour for the interface common to all classes as appropriate.
 * -- declares an interface for accessing and managing its child components.
 */
public interface Employee {

  String getName();

  BigDecimal getSalary();

  void print();

  void addEmployee(Employee e);
}

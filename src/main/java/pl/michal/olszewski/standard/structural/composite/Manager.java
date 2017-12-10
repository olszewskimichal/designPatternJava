package pl.michal.olszewski.standard.structural.composite;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Composite
 *
 * Wzorzec projektowy Composite jest strukturalnym wzorcem projektowym wykorzystywanym przy tworzeniu hierarchiczne struktury (drzewiastej) złożonej z obietków. Pozwala traktować jednakowo obiekty jak i grupy obiektów.
 */
public class Manager implements Employee {

  private final String name;
  private final BigDecimal salary;
  private List<Employee> employees = new ArrayList<>();

  public Manager(String name, BigDecimal salary) {
    this.name = name;
    this.salary = salary;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public BigDecimal getSalary() {
    BigDecimal allSalary = employees.stream().map(Employee::getSalary).reduce(BigDecimal.ZERO, BigDecimal::add);
    return salary.add(allSalary);
  }

  public void addEmployee(Employee e) {
    employees.add(e);
  }

  @Override
  public void print() {
    System.out.println(getName() + " " + getSalary());
    employees.forEach(Employee::print);
  }
}

package pl.michal.olszewski.standard.structural.composite;

import java.math.BigDecimal;

/**
 * Leaf
 *
 * - typ prosty - nie posiada potomków.
 */
public class Developer implements Employee {

  private final String name;
  private final BigDecimal salary;

  public Developer(String name, BigDecimal salary) {
    this.name = name;
    this.salary = salary;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public BigDecimal getSalary() {
    return salary;
  }

  @Override
  public void print() {
    System.out.println(getName() + " " + getSalary());
  }

  @Override
  public void addEmployee(Employee e) {
    throw new IllegalStateException("Developer nie moze miec pracowinika pod sobą");
  }
}

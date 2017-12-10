package pl.michal.olszewski.standard.structural.decorator;

import java.math.BigDecimal;

abstract class Product {

  abstract BigDecimal getPrice();

  abstract void getDescription();
}
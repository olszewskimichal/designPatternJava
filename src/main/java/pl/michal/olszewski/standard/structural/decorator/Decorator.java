package pl.michal.olszewski.standard.structural.decorator;

abstract class Decorator extends Product {

  final Product product;

  protected Decorator(Product product) {
    this.product = product;
  }
}

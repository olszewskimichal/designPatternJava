package pl.michal.olszewski.standard.design.decorator;

abstract class Decorator extends Product {

  final Product product;

  protected Decorator(Product product) {
    this.product = product;
  }
}

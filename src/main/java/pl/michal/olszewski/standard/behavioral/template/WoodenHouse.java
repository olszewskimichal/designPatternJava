package pl.michal.olszewski.standard.behavioral.template;

public class WoodenHouse extends HouseTemplate {

  @Override
  protected Material getHouseMaterial() {
    return Material.WOODEN;
  }

  @Override
  protected void buildWalls() {
    System.out.println("Building wooden walls");
  }

  @Override
  protected void buildPillars() {
    System.out.println("Building pillars with wood coating");
  }
}

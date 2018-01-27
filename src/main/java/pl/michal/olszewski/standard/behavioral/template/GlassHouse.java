package pl.michal.olszewski.standard.behavioral.template;

public class GlassHouse extends HouseTemplate {

  @Override
  protected Material getHouseMaterial() {
    return Material.GLASS;
  }

  @Override
  protected void buildWalls() {
    System.out.println("Building glass walls");
  }

  @Override
  protected void buildPillars() {
    System.out.println("Building pillars with glass coating");
  }
}

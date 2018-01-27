package pl.michal.olszewski.standard.behavioral.template;

public abstract class HouseTemplate {

  public final void buildHouse() {
    buildFoundation();
    buildPillars();
    buildWalls();
    buildWindows();
  }

  protected abstract Material getHouseMaterial();

  private void buildWindows() {
    System.out.println("Building glass windows");
  }

  protected abstract void buildWalls();

  protected abstract void buildPillars();

  private void buildFoundation() {
    System.out.println("Building foundation with cement,iron rods and sand");
  }

}

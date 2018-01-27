package pl.michal.olszewski.standard.behavioral.template;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class TemplateTest {

  @Test
  void glassHouseTest() {
    HouseTemplate houseTemplate = new GlassHouse();
    houseTemplate.buildHouse();
    assertThat(houseTemplate.getHouseMaterial()).isEqualTo(Material.GLASS);
  }

  @Test
  void woodenHouseTest() {
    HouseTemplate houseTemplate = new WoodenHouse();
    houseTemplate.buildHouse();
    assertThat(houseTemplate.getHouseMaterial()).isEqualTo(Material.WOODEN);
  }

}

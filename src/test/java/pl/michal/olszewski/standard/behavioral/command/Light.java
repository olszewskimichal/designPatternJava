package pl.michal.olszewski.standard.behavioral.command;

/**
 * Receiver
 *
 * dowolny obiekt, na którym polecenia potrafią wykonać operacje. W praktyce w skład modelu może wchodzić dowolnie duża liczba klas i obiektów.
 */
public class Light {

  private Boolean on;

  public void switchOn() {
    on = true;
  }

  public void switchOff() {
    on = false;
  }

  public Boolean getOn() {
    return on;
  }
}

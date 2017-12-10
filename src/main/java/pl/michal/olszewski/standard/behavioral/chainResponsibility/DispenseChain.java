package pl.michal.olszewski.standard.behavioral.chainResponsibility;

import static java.lang.System.out;

import java.math.BigDecimal;

/**
 * Chain of Responsibility
 *
 * nazywany jest również łańcuchem zobowiązań, ponieważ jego głównym zadaniem  jest przekazanie zobowiązania obsługi żądania na kolejny element w łańcuchu. Łańcuch takich obiektów tworzy listę jednokierunkową, w której odpowiedzialność za przetworzone żądanie spada na najlepiej przygotowany do tego obiekt.
 *
 * Zalety:
 * - klient, przekazując żądanie, nie wie, który z obiektów będzie je w rzeczywistości obsługiwał
 * - możliwość elastycznego przydziału odpowiedzialności do obiektów
 *
 * Wady:
 * - brak gwarancji obsługi żądania: kolejne ogniwa mogą zrezygnować z zajęcia się nim
 */
public interface DispenseChain {

  BigDecimal getDispenseValue();

  DispenseChain getNext();

  void setNext(DispenseChain next);

  default Integer dispense(BigDecimal currency) {
    if (currency.compareTo(getDispenseValue()) >= 0) {
      currency = currency.subtract(getDispenseValue());
      out.println("Wydałem " + getDispenseValue());
      if (currency.compareTo(BigDecimal.ZERO) != 0) {
        return this.dispense(currency) + 1;
      }
      return 1;
    } else {
      return this.getNext().dispense(currency);
    }
  }
}

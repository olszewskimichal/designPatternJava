package pl.michal.olszewski.standard.behavioral.command;

/**
 * Polecenie (ang. command) - czynnościowy wzorzec projektowy. Jego celem jest enkapsulacja żądań użytkownika (wraz z ich parametrami) do postaci obiektów, które nazywamy poleceniami.
 *
 * Zalety:
 * oddzielenie operacji od obiektów, na których jest ona wykonywana,
 * polecenia są reprezentowane jako standardowe obiekty, dzięki czemu możemy na nich stosować wszystkie manipulacje dopuszczalne w programowaniu obiektowym,
 * możliwość łączenia elementarnych poleceń w polecenia złożone,
 * łatwość dodawania nowych rodzajów poleceń.
 * Wady:
 * każde polecenie wymaga dodatkowej pamięci na zapamiętanie stanu swojego obiektu.
 *
 * Uses
 * GUI buttons and menu items
 */

/**
 * interfejs definiujący operacje, jakie musi obsługiwać każde polecenie (wykonywanie zadania, wycofywanie zmian itd.)
 */
public interface Command {

  void execute();

  void cancel();
}

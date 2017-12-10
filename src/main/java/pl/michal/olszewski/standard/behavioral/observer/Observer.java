package pl.michal.olszewski.standard.behavioral.observer;

/**
 * Używany jest do powiadamiania zainteresowanych obiektów o zmianie stanu pewnego innego obiektu.
 *
 * Zalety:
 * Luźna zależność między obiektem obserwującym i obserwowanym. Ponieważ nie wiedzą one wiele o sobie nawzajem, mogą być niezależnie rozszerzane i rozbudowywane bez wpływu na drugą stronę.
 * Relacja między obiektem obserwowanym a obserwatorem tworzona jest podczas wykonywania programu i może być dynamicznie zmieniana.
 * Możliwość zablokowania klientowi drogi do bezpośredniego korzystania ze złożonego systemu, jeśli jest to konieczne.
 *
 * Wady:
 * Obserwatorzy nie znają innych obserwatorów, co w pewnych sytuacjach może wywołać trudne do znalezienia skutki uboczne.
 * Możliwość zapętlenia się aplikacji w przypadku gdy jeden obserwator zmieni swój stan, a jest obserwowany przez inny obiekt, który jest obserwowany przez pierwszy obiekt. W tym przypadku grozi nam wieczna pętla i wykorzystanie 100% CPU
 *
 * Zastosowanie:
 * Wzorzec Obserwatora sprawdza się wszędzie tam, gdzie stan jednego obiektu uzależniony jest od stanu drugiego obiektu.
 */
abstract class Observer {

  protected Subject subject;

  public abstract void update(Integer oldValue);
}

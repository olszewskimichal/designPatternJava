package pl.michal.olszewski.standard.behavioral.strategy;

/**
 * wzorzec projektowy, który definiuje rodzinę wymiennych algorytmów i kapsułkuje je w postaci klas. Dzięki temu umożliwia wymienne stosowanie każdego z nich w trakcie działania programu.

 Zalety i wady
 Zalety:

 Eliminacja instrukcji warunkowych – kod jest bardziej przejrzysty.
 Umożliwia wybór implementacji – algorytmy mogą rozwiązywać ten sam problem, lecz różnić się uzyskiwanymi korzyściami.
 Łatwość dołączania kolejnych strategii.
 Łatwiejsze testowanie programu – można debugować każdą strategię z osobna.
 Wady:

 Dodatkowy koszt komunikacji między klientem, a strategią (wywołania metod, przekazywanie danych).
 „Rozmycie” kodu na kilka klas.
 Zastosowanie
 Wszędzie tam, gdzie istnieje potrzeba rozwiązania danego problemu na kilka różnych sposobów.

 Oficjalna wirtualna maszyna Javy HotSpot wykorzystuje wzorzec strategii w wewnętrznej implementacji mechanizmu odśmiecania pamięci, oferując do wyboru kilka algorytmów różniących się właściwościami. Sam programista wybiera strategię odśmiecania najlepiej dopasowaną do profilu jego aplikacji.


 Zalety:
 wzorzec pozwala na ścisłe, formalne zdefiniowanie rozszerzalnych rodzin algorytmów dzięki wprowadzeniu interfejsu Strategia,
 bazuje na koncepcji kompozycji, a nie na dziedziczeniu — nie ma sztywnego powiązania między algorytmem a miejscem jego wykorzystania. Może on być wymieniany w trakcie działania programu,
 eliminacja instrukcji warunkowych,
 umożliwia wybór implementacji — algorytmy mogą rozwiązywać ten sam problem, lecz różnić się uzyskiwanymi korzyściami (zużycie pamięci, złożoność obliczeniowa, optymalizacja pod kątem pewnych szczególnych przypadków).
 możliwość niezależnego testowania klientów i strategii[1]
 Wady:
 dodatkowy koszt komunikacji między klientem a strategią (wywołania metod, przekazywanie danych),
 zwiększenie liczby obiektów.
 */
public interface Strategy<T> {

  T calculate(T firstValue, T secondValue);
}

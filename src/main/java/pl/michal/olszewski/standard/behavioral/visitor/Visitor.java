package pl.michal.olszewski.standard.behavioral.visitor;

/**
 *
 * Zadaniem wzorca projektowego Visitor jest oddzielenie algorytmu od struktury obiektów, na
 * których operuje. W opisywanym wzorcu projektowym wprowadzony zostaje nowy obiekt Visitor,
 * którego zadaniem jest odwiedzenie każdego z obiektów pewnego zespołu i wykonanie na każdym z
 * nich konkretnej operacji
 *
 * Uzywamy np by uniknać ifologii z instanceOf
 *
 * Wady
 * --Dodanie nowego elementu, który ma być obsługiwany przez wzorzec wymusza dodanie implementacji obsługi do wszystkich istniejących odwiedzających.
 * -- Każdy odwiedzający musi mieć dostęp do składowych elementu co oznacza, że każdy element musi mieć publiczny dostęp do używanych składowych obiektu.
 *
 * Zalety
 * -- Wymusza dodanie obsługi implementacji do wszystkich istniejących odwiedzających zapewniając tym samym obsługę elementu przez wszystkie zadania.
 * -- Grupuje funkcjonalność logicznie powiązaną ze sobą w jedną klasę przez co dużo łatwiej jest ją rozwijać i utrzymywać.
 */
public interface Visitor<T> {

  T visit(Foo foo);

  T visit(Bar bar);

  T visit(Baz baz);
}
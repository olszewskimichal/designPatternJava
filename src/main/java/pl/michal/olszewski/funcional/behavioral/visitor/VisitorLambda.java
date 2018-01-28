package pl.michal.olszewski.funcional.behavioral.visitor;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import pl.michal.olszewski.standard.behavioral.visitor.Bar;
import pl.michal.olszewski.standard.behavioral.visitor.Baz;
import pl.michal.olszewski.standard.behavioral.visitor.Foo;
import pl.michal.olszewski.standard.behavioral.visitor.Visitable;

public class VisitorLambda {

  public static class LambdaVisitor<A> implements Function<Visitable, A> {

    private Map<Class<?>, Function<Visitable, A>> fMap = new HashMap<>();

    <B> Acceptor<A, B> on(Class<B> clazz) {
      return new Acceptor<>(this, clazz);
    }

    @Override
    public A apply(Visitable o) {
      return fMap.get(o.getClass()).apply(o);
    }

    static class Acceptor<A, B> {

      private final LambdaVisitor visitor;
      private final Class<B> clazz;

      public Acceptor(LambdaVisitor<A> visitor, Class<B> clazz) {
        this.visitor = visitor;
        this.clazz = clazz;
      }

      public LambdaVisitor<A> then(Function<B, A> f) {
        visitor.fMap.put(clazz, f);
        return visitor;
      }
    }
  }

  public static Function<Visitable, String> stringVisitor = new LambdaVisitor<String>()
      .on(Bar.class).then(s -> "BAR")
      .on(Baz.class).then(c -> "BAZ")
      .on(Foo.class).then(r -> "FOO");

  public static Function<Visitable, BigDecimal> bigDecimalVisitor = new LambdaVisitor<BigDecimal>()
      .on(Bar.class).then(s -> BigDecimal.ONE)
      .on(Baz.class).then(c -> BigDecimal.ZERO)
      .on(Foo.class).then(r -> BigDecimal.TEN);

}
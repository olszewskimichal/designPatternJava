package pl.michal.olszewski.standard.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject
 *
 * Obiekt obserwowany (observable, subject) – obiekt, który interesuje nas pod względem zmiany stanów
 */
public class Subject {

  private List<Observer> observers = new ArrayList<>();
  private Integer state;

  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  public void notifyAllObservers(Integer oldValue) {
    observers.forEach(v -> v.update(oldValue));
  }

  public Integer getState() {
    return state;
  }

  public void setState(Integer newValue) {
    Integer oldValue = this.state;
    this.state = newValue;
    notifyAllObservers(oldValue);
  }
}

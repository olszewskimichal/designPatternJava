package pl.michal.olszewski.standard.design.chainResponsibility;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DispenserTest {

  private DispenseChain dispenseChain;

  @BeforeEach
  void setUp() {
    dispenseChain = new Dollar50Dispenser();
    DispenseChain dispenseChain2 = new Dollar20Dispenser();
    DispenseChain dispenseChain3 = new Dollar10Dispenser();
    dispenseChain.setNext(dispenseChain2);
    dispenseChain2.setNext(dispenseChain3);
  }

  @Test
  void shouldDispenseAllMoney() {
    //given
    BigDecimal bigDecimal = BigDecimal.valueOf(130);
    //when
    Integer dispense = dispenseChain.dispense(bigDecimal);
    //then
    assertThat(dispense).isEqualTo(4);
  }

  @Test
  void shouldNotDispenseAllMoneyAndThrowException() {
    //given
    BigDecimal bigDecimal = BigDecimal.valueOf(75);
    //when
    //then
    assertThrows(NullPointerException.class, () -> dispenseChain.dispense(bigDecimal));
  }

}
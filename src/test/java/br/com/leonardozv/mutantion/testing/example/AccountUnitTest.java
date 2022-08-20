package br.com.leonardozv.mutantion.testing.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootConfiguration
@SpringBootTest
class AccountUnitTest {

    @Test
    void mustCreditSpecifiedValue() {

        Account account = new Account(5);

        account.credit(1);

        assertEquals(6, account.getBalance());

    }

    @Test
    void mustDebitSpecifiedValue() {

        Account account = new Account(5);

        try {
            account.debit(1);
        } catch (Exception ignored) { }

        assertEquals(4, account.getBalance());

    }

//    @Test
//    void mustThrowExceptionWhenDebitMakesBalanceNegative() {
//
//        Account account = new Account(0);
//
//        assertThrows(BalanceCannotBecomeNegativeException.class, () -> account.debit(1));
//
//    }
//
//    @Test
//    void mustNotThrowExceptionWhenDebitMakesBalanceZero() {
//
//        Account account = new Account(1);
//
//        assertDoesNotThrow(() -> account.debit(1));
//
//    }

}

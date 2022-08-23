package br.com.leonardozv.mutation.testing.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountUnitTest {

    private Account account;

    @BeforeEach
    void setUp() {
        this.account = new Account(5);
    }

    @Test
    void whenCredit_thenBalanceMustIncrease() {

        this.account.credit(1);

        assertEquals(6, account.getBalance());

    }

    @Test
    void whenDebitMakesAccountBalancePositive_thenBalanceMustDecrease() {

        try {
            this.account.debit(1);
        } catch (Exception ignored) { }

        assertEquals(4, account.getBalance());

    }

    @Test
    void whenDebitMakesAccountBalanceNegative_thenThrowException() {

        assertThrows(BalanceCannotBecomeNegativeException.class, () -> this.account.debit(6));

    }

    @Test
    void whenDebitMakesAccountBalanceZero_thenNotThrowException() {

        assertDoesNotThrow(() -> account.debit(5));

    }

}

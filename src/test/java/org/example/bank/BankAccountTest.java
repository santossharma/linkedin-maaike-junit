package org.example.bank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by santoshsharma on 25 Sep, 2022
 */

@DisplayName("Test BankAccount class")
class BankAccountTest {

    @Test
    @DisplayName("Withdraw 300 successfully")
    void testWithdraw() {
        BankAccount bankAccount = new BankAccount(500, -1000);

        bankAccount.withdraw(300);

        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 500 successfully")
    void testDeposit() {
        BankAccount bankAccount = new BankAccount(400, 0);
        bankAccount.deposit(500);
        assertEquals(900, bankAccount.getBalance());
    }

    @Test
    void testBankHolderName() {
        BankAccount bankAccount = new BankAccount(400, 0);
        bankAccount.setHolderName("Santosh");

        assertNotNull(bankAccount.getHolderName());
    }

    @Test
    @DisplayName("Test that we can't withdraw below minimum balance")
    void testWithdrawBelowMinimumBalance() {
        BankAccount bankAccount = new BankAccount(400, 100);

        assertThrows(RuntimeException.class, () -> bankAccount.withdraw(400));
    }

    @Test
    @DisplayName("Test no exception while doing withdraw and deposit")
    void testWithdrawAndDepositWithoutExceptions() {
        BankAccount bankAccount = new BankAccount(400, 0);

        assertAll(() -> bankAccount.deposit(100), () -> bankAccount.withdraw(500));
    }

    @Test
    @DisplayName("Test no exception while doing withdraw and deposit")
    void testWithdrawAndDepositWithExceptions() {
        BankAccount bankAccount = new BankAccount(400, 100);
        bankAccount.deposit(100);

        assertThrows(RuntimeException.class, () -> bankAccount.withdraw(500));
    }

}
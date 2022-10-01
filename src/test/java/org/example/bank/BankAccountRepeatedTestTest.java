package org.example.bank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by santoshsharma on 27 Sep, 2022
 *
 */
@DisplayName("Tests repeated test through parameterized testing")
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountRepeatedTestTest {

    @RepeatedTest(5)
    @DisplayName("Repeated testing")
    void testDeposit(BankAccount bankAccount) {
        bankAccount.deposit(500.00);
        assertEquals(500.00, bankAccount.getBalance());
    }

    @RepeatedTest(5)
    @DisplayName("Repeated testing")
    void testDepositRepetition(BankAccount bankAccount, RepetitionInfo repetitionInfo) {
        bankAccount.deposit(500.00);
        assertEquals(500.00, bankAccount.getBalance());

        System.out.println("Repetition Count : " + repetitionInfo.getCurrentRepetition());
    }

}
